/**
 * Project Name:TestAndroidExample File Name:MySurfaceViewActivity.java Package
 * Name:com.example.test.surfaceview Date:2015-11-30 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.surfaceview;

import android.app.Activity;
import android.os.Bundle;

/**
 * ClassName: MySurfaceViewActivity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-30
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class MySurfaceViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(new MySurfaceView(this));
    }
}
