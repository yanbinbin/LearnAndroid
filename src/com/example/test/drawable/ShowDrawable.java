/**
 * Project Name:TestAndroidExample File Name:TestDrawable.java Package
 * Name:com.example.test.drawable Date:2016-1-1 Copyright (c) 2016,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.drawable;

import com.example.test.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * ClassName: TestDrawable <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2016-1-1
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class ShowDrawable extends Activity {
    ImageView mIconView;
    int flag;

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_show_drawable);
        mIconView = (ImageView)findViewById(R.id.icon);
        flag = getIntent().getFlags();
        switch (flag) {
        case 0:
            break;

        default:
            break;
        }
    }
}
