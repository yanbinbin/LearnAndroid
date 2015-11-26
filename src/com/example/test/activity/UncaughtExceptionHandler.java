/**
 * Project Name:TestAndroidExample
 * File Name:UncaughtExceptionHandler.java
 * Package Name:com.example.test
 * Date:2015-11-25
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * ClassName: UncaughtExceptionHandler <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-11-25
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class UncaughtExceptionHandler extends Activity {
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Log.d("bb", "getCacheDir() = " + getCacheDir());
        Log.d("bb", "getFilesDir() = "+ getFilesDir());
        Log.d("bb", "getExternalCacheDir() = " + getExternalCacheDir());
        Log.d("bb", "getPackageResourcePath() = " + getPackageResourcePath());
        Log.d("bb", "getPackageCodePath() = " + getPackageCodePath());
        Log.d("bb", "getObbDir() = " + getObbDir());
        String temp = null;
        System.out.println(temp.getBytes());
    }
}
