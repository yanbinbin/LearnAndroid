/**
 * Project Name:TestAndroidExample
 * File Name:MyApplication.java
 * Package Name:com.example.test
 * Date:2015-11-25
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.activity;

import com.example.test.activity.helper.CrashHander;

import android.app.Application;
import android.util.Log;

/**
 * ClassName: MyApplication <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-11-25
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class MyApplication extends Application {

    /* (non-Javadoc)
     * @see android.app.Application#onCreate()
     */
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        CrashHander hander = CrashHander.getInstance();
        hander.init(this);
        Log.d("bb", "MyApplication--->onCreate()...");
    }
}
