/**
 * Project Name:TestAndroidExample File Name:ClientActivity.java Package
 * Name:com.example.test.binder Date:2015-12-22 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.binder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.example.test.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * ClassName: ClientActivity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-22
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class ClientActivity extends Activity implements OnClickListener{
    private static final int MSG_SOCKET_CONNECTED = 1;
    private static final int MSG_RECEIVE_NEW_MESSAGE = 2;

    private Button mSendButton;
    private EditText mInputText;
    private TextView mInfoView;

    private PrintWriter mOut;
    private Socket mClient;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case MSG_SOCKET_CONNECTED:
                mInfoView.setText("连接上服务端。。。");
                mSendButton.setEnabled(true);

                break;
            case MSG_RECEIVE_NEW_MESSAGE:
                mInfoView.setText(mInfoView.getText() + "\n" + msg.obj);

                break;

            default:
                break;
            }
        };
    };

    private void testBinderPool(Context context) {
        BinderPool binderPool = BinderPool.getInstance(context);
        ICompute computeBinder = (ICompute)binderPool.queryBinder(BinderPool.CODE_BINDER_COMPUTE);
        IPrint print = (IPrint)binderPool.queryBinder(BinderPool.CODE_BINDER_PRINT);
        try {
            print.print("开始计算。。。compute = " + computeBinder);
            print.print("1 +3 = " + computeBinder.add(1, 3));
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        testBinderPool(this);
//        setContentView(R.layout.layout_test_socket);
//        mInfoView = (TextView) findViewById(R.id.info);
//        mInputText = (EditText) findViewById(R.id.input);
//        mSendButton = (Button) findViewById(R.id.send);
//        mSendButton.setOnClickListener(this);
//        Intent intent = new Intent(this, SocketService.class);
//        startService(intent);
//        new Thread(new Runnable() {
//            
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                connectToServer();
//            }
//        }).start();
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onDestroy()
     */
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        if (mClient != null) {
            try {
                mClient.shutdownInput();
                mClient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        super.onDestroy();
    }

    private String formatDateTime(long time) {
        return new SimpleDateFormat("(HH:mm:ss)").format(new Date(time));
    }
    /* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
        case R.id.send:
            final String msg = mInputText.getText().toString();
            if (!TextUtils.isEmpty(msg) && mOut != null) {
                mOut.println(msg);
                mInputText.setText("");
                String timeString = formatDateTime(System.currentTimeMillis());
                String showMsg = "客户端：" + mClient.getPort() + " 在" + timeString + "给服务器端发送" + msg + "\n";
                mInfoView.setText(mInfoView.getText() + "\n" + showMsg);
            }
            break;

        default:
            break;
        }
    }

    private void connectToServer() {
        // TODO Auto-generated method stub
        Log.d("bb", "connectToServer()...");
        Socket socket = null;
        while (socket == null) {
            try {
                socket = new Socket("localhost", 8654);
                Log.d("bb", "连接成功？");
                mClient = socket;
                mOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mClient.getOutputStream())));
                mHandler.sendEmptyMessage(MSG_SOCKET_CONNECTED);
            } catch (UnknownHostException e) {
                SystemClock.sleep(2000);
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                SystemClock.sleep(2000);
                e.printStackTrace();
            }
        }

        // 接收服务器端的消息
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(mClient.getInputStream()));
            while (!ClientActivity.this.isFinishing()) {
                String msg = reader.readLine();
                if (TextUtils.isEmpty(msg)) {
                    String timeString = formatDateTime(System.currentTimeMillis());
                    String showMsg = "客户端：" + mClient.getPort() + " 在" + timeString + "收到服务器端消息：" + msg + "\n";
                    mHandler.obtainMessage(MSG_RECEIVE_NEW_MESSAGE, showMsg).sendToTarget();
                }
            }
            mInfoView.setText("客户端退出。");
            mOut.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
