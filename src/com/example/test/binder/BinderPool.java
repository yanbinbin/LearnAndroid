/**
 * Project Name:TestAndroidExample File Name:BinderPool.java Package
 * Name:com.example.test.binder Date:2015-12-23 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.binder;

import java.util.concurrent.CountDownLatch;

import com.example.test.utils.ExplicitIntentUtilsForL;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.RemoteException;
import android.util.Log;

/**
 * ClassName: BinderPool <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-23
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class BinderPool {

    public static final int CODE_BINDER_NONE = -1;
    public static final int CODE_BINDER_PRINT = 1;
    public static final int CODE_BINDER_COMPUTE = 2;

    private Context mContext;
    private IBinderPool mBinderPool;
    private static volatile BinderPool sInstance;
    private CountDownLatch mCountDownLatch;

    /**
     * 
     */
    private BinderPool(Context context) {
        // TODO Auto-generated constructor stub
        mContext = context;
        connectBinderPoolService();
    }

    public static BinderPool getInstance(Context context) {
        if (sInstance == null) {
            synchronized (BinderPool.class) {
                if (sInstance == null) {
                    sInstance = new BinderPool(context);
                }
            }
        }
        return sInstance;
    }

    /**
     * connectBinderPoolService: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void connectBinderPoolService() {
        // TODO Auto-generated method stub
        mCountDownLatch = new CountDownLatch(1);
        Intent intent = new Intent("com.bb.test.binderpoolservice");
        Intent exIntent = ExplicitIntentUtilsForL.getExplicitIntent(mContext, intent);
        mContext.bindService(exIntent, mConn, Context.BIND_AUTO_CREATE);
        try {
            mCountDownLatch.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public IBinder queryBinder(int binderCode) {
        IBinder binder = null;
        if (mBinderPool != null) {
            try {
                binder = mBinderPool.queryBinder(binderCode);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return binder;
    }

    private ServiceConnection mConn = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            // TODO Auto-generated method stub
            Log.d("bb", "绑定断开");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // TODO Auto-generated method stub
            Log.d("bb", "绑定上服务");
            mBinderPool = IBinderPool.Stub.asInterface(service);
            try {
                mBinderPool.asBinder().linkToDeath(mDeathRecipient, 0);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            mCountDownLatch.countDown();
        }
    };

    private IBinder.DeathRecipient mDeathRecipient = new DeathRecipient() {

        @Override
        public void binderDied() {
            // TODO Auto-generated method stub
            Log.d("bb", "服务挂掉。");
            try {
                mBinderPool.asBinder().linkToDeath(mDeathRecipient, 0);
            } catch (RemoteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            mBinderPool = null;
            connectBinderPoolService();
        }
    };
}
