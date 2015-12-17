/**
 * Project Name:TestAndroidExample File Name:TestAppUpdateIncrease.java Package
 * Name:com.example.test.activity Date:2015-11-30 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.activity;

import java.io.File;

import com.lib.bsdiff.BsdiffJNI;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

/**
 * ClassName: TestAppUpdateIncrease <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-30
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class TestAppUpdateIncrease extends Activity {
    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        Thread thread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Log.d("bb", "开始生成新的apk");
                BsdiffJNI jni = new BsdiffJNI();
                jni.bspatch(Environment.getExternalStorageDirectory().getAbsolutePath()
                        + File.separator + "iReader1.6.2.0(v35).apk", Environment
                        .getExternalStorageDirectory().getAbsolutePath() + File.separator + "iReader1.8.0.1(v40).apk", Environment
                        .getExternalStorageDirectory().getAbsolutePath()
                        + File.separator + "bspatch");
                Log.d("bb", "新的apk生成完成");
            }
        });
        thread.start();
    }

}
