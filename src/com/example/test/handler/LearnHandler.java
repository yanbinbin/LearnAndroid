/**
 * Project Name:TestAndroidExample File Name:LearnHandler.java Package
 * Name:com.example.test.handler Date:2016-1-5 Copyright (c) 2016, www.meitu.com
 * All Rights Reserved.
 */

package com.example.test.handler;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * ClassName: LearnHandler <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2016-1-5
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class LearnHandler extends Activity {
    private ThreadLocal<Boolean> mBooThreadLocal = new ThreadLocal<Boolean>();

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        learnThreadLocal();
    }

    /**
     * learnThreadLocal: ThreadLocal的基本掌握<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void learnThreadLocal() {
        mBooThreadLocal.set(true);
        Log.d("bb", Thread.currentThread() + "---> mBooThreadLocal = "
                + mBooThreadLocal.get());

        new Thread("Thread#1") {
            public void run() {
                mBooThreadLocal.set(false);
                Log.d("bb", Thread.currentThread() + "---> mBooThreadLocal = "
                        + mBooThreadLocal.get());
            };
        }.start();

        new Thread("Thread#2") {
            public void run() {
                Log.d("bb", Thread.currentThread() + "---> mBooThreadLocal = "
                        + mBooThreadLocal.get());
            };
        }.start();
    }
}
