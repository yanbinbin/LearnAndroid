/**
 * Project Name:TestAndroidExample File Name:TestDrawable.java Package
 * Name:com.example.test.drawable Date:2016-1-1 Copyright (c) 2016,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.drawable;

import com.example.test.R;

import android.R.integer;
import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
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
    ImageView mIconLevelList;
    int flag;

    int level = 0;
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
        mIconLevelList = (ImageView)findViewById(R.id.icon_level_list);
        mIconLevelList.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                level ++;
                if (level > 4) {
                    level/=4;
                }
                mIconLevelList.setImageLevel(level);
                Log.d("bb", "onClick : level = " + level);
            }
        });
        flag = getIntent().getFlags();
        switch (flag) {
        case 0:
            break;

        default:
            break;
        }
    }
}
