/**
 * Project Name:TestBinder
 * File Name:BinderRemoteService.java
 * Package Name:com.example.testbinder
 * Date:2015-12-17
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.testbinder;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/**
 * ClassName: BinderRemoteService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-12-17
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class BinderRemoteService extends Service {
    private static class MessengerHandler extends Handler {
        /* (non-Javadoc)
         * @see android.os.Handler#handleMessage(android.os.Message)
         */
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            switch (msg.what) {
            case 0:
                Log.d("bb", "服务端收到消息：" + msg.getData().getString("msg"));
                Messenger client = msg.replyTo;
                Message replyMessage = Message.obtain(null, 1);
                Bundle data = new Bundle();
                data.putString("smsg", "来自服务端的回复");
                replyMessage.setData(data);
                try {
                    client.send(replyMessage);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;

            default:
                break;
            }
            super.handleMessage(msg);
        }
    }
    private final Messenger mMessenger = new Messenger(new MessengerHandler());

    /* (non-Javadoc)
     * @see android.app.Service#onBind(android.content.Intent)
     */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return mMessenger.getBinder();
    }

}
