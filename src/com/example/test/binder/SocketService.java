/**
 * Project Name:TestBinderAsServer File Name:SocketService.java Package
 * Name:com.example.testbinder Date:2015-12-22 Copyright (c) 2015, www.meitu.com
 * All Rights Reserved.
 */

package com.example.test.binder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

/**
 * ClassName: SocketService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-22
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class SocketService extends Service {
    private boolean mIsServiceAlive = true;
    private String[] mReplyWords = new String[] {
            "雷猴啊。。", "很高兴认识你", "Nice to see you !", "饭否？", "苦逼的我还在加班。。"
    };

    /* (non-Javadoc)
     * @see android.app.Service#onCreate()
     */
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        new ServiceThread().start();
        super.onCreate();
        Log.d("bb", "服务器起来。。。");
    }
    /*
     * (non-Javadoc)
     * @see android.app.Service#onBind(android.content.Intent)
     */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * @see android.app.Service#onDestroy()
     */
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        mIsServiceAlive = false;
        super.onDestroy();
    }

    private class ServiceThread extends Thread {
        /*
         * (non-Javadoc)
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            // TODO Auto-generated method stub
            super.run();
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(8654);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            while (mIsServiceAlive) {
                try {
                    final Socket client = serverSocket.accept();
                    Log.d("bb", "接收到客户端连接.." + client.getPort());
                    new Thread(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            try {
                                responseClient(client);
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }).start();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * responseClient: 回复客户端<br/>
     * 
     * @author meitu.yanbb
     * @param client
     * @throws IOException
     * @since MT 1.0
     */
    private void responseClient(Socket client) throws IOException {
        // TODO Auto-generated method stub
        // 用于接收客户端消息
        BufferedReader in = new BufferedReader(new InputStreamReader(
                client.getInputStream()));
        Log.d("bb", "客户端in = " + in);
        // 用于向客户端发送消息
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new OutputStreamWriter(client.getOutputStream())));
        out.println("欢迎连接服务器！");
        while (mIsServiceAlive) {
            String clientInput = in.readLine();
            Log.d("bb", "接收到客户端消息：" + clientInput);
            if (TextUtils.isEmpty(clientInput)) {
                // 断开与客户端的连接
                break;
            }
            int random = new Random().nextInt(mReplyWords.length);
            String msg = mReplyWords[random];
            out.println(msg);
            Log.d("bb", "服务器返回：" + msg);
            Log.e("bb", "断开与" + client.getPort() + " 的连接。");
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
            client.close();
        }
    }
}
