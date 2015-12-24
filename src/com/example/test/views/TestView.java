/**
 * Project Name:TestAndroidExample
 * File Name:TestView.java
 * Package Name:com.example.test.views
 * Date:2015-12-23
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.views;

import com.example.test.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.TextView;

/**
 * ClassName: TestView <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-12-23
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class TestView extends Activity{

    TextView mTextView;
    MyScrollerView mTestScrollerView;
    
    
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test_view);
        mTextView = (TextView) findViewById(R.id.textView1);
        mTestScrollerView = (MyScrollerView) findViewById(R.id.textView2);
    }
    /* (non-Javadoc)
     * @see android.app.Activity#onResume()
     */
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
//        new Thread(new Runnable() {
//            
//            @Override
//            public void run() {
//                // TODO Auto-generated method stub
//                SystemClock.sleep(3000);
//                runOnUiThread(new Runnable() {
//                    public void run() {
//                        mTextView.scrollTo(-200, 0);
//                    }
//                });
//            }
//        }).start();
        new NonUiThread().start();
        mTestScrollerView.smoothScrollTo(50, 0);
        super.onResume();
    }

    class NonUiThread extends Thread {
        /* (non-Javadoc)
         * @see java.lang.Thread#run()
         */
        @Override
        public void run() {
            // TODO Auto-generated method stub
            Looper.prepare();
            // TODO Auto-generated method stub
            SystemClock.sleep(3000);
            /**
             * 边缘左上减去内容左上xs
             */
            mTextView.scrollTo(-20, 20);
            Looper.loop();
            super.run();
        }
    }
}
