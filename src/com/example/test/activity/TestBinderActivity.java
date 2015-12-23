/**
 * Project Name:TestAndroidExample
 * File Name:TestBinderActivity.java
 * Package Name:com.example.test.activity
 * Date:2015-12-17
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.activity;

import com.example.test.binder.Book;
import com.example.test.binder.ClientActivity;
import com.example.test.binder.IOnNewBookArrivedListener;

import java.util.List;

import com.example.test.binder.IBookManager;
import com.example.test.utils.ExplicitIntentUtilsForL;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

/**
 * ClassName: TestBinderActivity <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-12-17
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class TestBinderActivity extends Activity {
    private static final int MSG_NEW_BOOK_ARRIVED = 1;
//    private Messenger mMessenger;
//    private Messenger mGetMessenger = new Messenger(new MessengerHandler());
//    private static class MessengerHandler extends Handler{
//        /* (non-Javadoc)
//         * @see android.os.Handler#handleMessage(android.os.Message)
//         */
//        @Override
//        public void handleMessage(Message msg) {
//            // TODO Auto-generated method stub
//            switch (msg.what) {
//            case 1:
//                Log.d("bb", "客户端收到消息:" + msg.getData().getString("smsg"));
//                break;
//
//            default:
//                break;
//            }
//            super.handleMessage(msg);
//        }
//    }
//    /* (non-Javadoc)
//     * @see android.app.Activity#onCreate(android.os.Bundle)
//     */
//    ServiceConnection mConnection = new ServiceConnection() {
//        
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            // TODO Auto-generated method stub
//        }
//        
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            // TODO Auto-generated method stub
//            mMessenger = new Messenger(service);
//            Message msg = Message.obtain(null, 0);
//            Bundle bundle = new Bundle();
//            bundle.putString("msg", "这是从客户端传送来的数据");
//            msg.setData(bundle);
//            msg.replyTo = mGetMessenger;
//            try {
//                mMessenger.send(msg);
//            } catch (RemoteException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    };

    private IBookManager mBookManager;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case MSG_NEW_BOOK_ARRIVED:
                Log.d("bb", "收到新书：" + ((Book)msg.obj).getName() + "; " + ((Book)msg.obj).getAge());
                break;

            default:
                break;
            }
        };
    };
    private IOnNewBookArrivedListener mListener = new IOnNewBookArrivedListener.Stub() {
        @Override
        public void onNewBookArrived(Book newBook) throws RemoteException {
            // TODO Auto-generated method stub
            mHandler.obtainMessage(MSG_NEW_BOOK_ARRIVED, newBook).sendToTarget();
        }
    };

    private ServiceConnection mAIDLConnection = new ServiceConnection() {
        
        @Override
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub
            Log.d("bb", "onServiceDisconnected(): 客户端断开连接、、、");
        }
        
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub
            mBookManager = IBookManager.Stub.asInterface(service);
            try {
                mBookManager.registerListener(mListener);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
//        Intent intent = new Intent("com.bb.test.aidl");
//        Intent exIntent = ExplicitIntentUtilsForL.getExplicitIntent(this, intent);
//        bindService(exIntent, mAIDLConnection, Context.BIND_AUTO_CREATE);
        
//        Intent intent = new Intent("com.bb.com");
//        Intent exIntent = ExplicitIntentUtilsForL.getExplicitIntent(this, intent);
//        bindService(exIntent, mConnection, Context.BIND_AUTO_CREATE);
    }
    /* (non-Javadoc)
     * @see android.app.Activity#onDestroy()
     */
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if (mBookManager != null && mBookManager.asBinder().isBinderAlive()) {
            try {
                Log.d("bb", "开始注解...");
                mBookManager.unRegisterListener(mListener);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        unbindService(mAIDLConnection);
//        unbindService(mConnection);
    }

}
