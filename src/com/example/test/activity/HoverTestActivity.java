/**
 * Project Name:TestAndroidExample File Name:HoverTestActivity.java Package
 * Name:com.example.test Date:2015-11-20 Copyright (c) 2015, www.meitu.com All
 * Rights Reserved.
 */

package com.example.test.activity;

import com.example.test.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnHoverListener;
import android.widget.Button;

/**
 * ClassName: HoverTestActivity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-20
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class HoverTestActivity extends Activity {

    private Button mHoverButton;

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_hover);
        mHoverButton = (Button)findViewById(R.id.button);
        mHoverButton.setOnHoverListener(new OnHoverListener() {
            @Override
            public boolean onHover(View v, MotionEvent event) {
                int what = event.getAction();
                switch (what) {
                case MotionEvent.ACTION_HOVER_ENTER:
                    Log.d("bb", "鼠标进入");
                    break;
                case MotionEvent.ACTION_HOVER_MOVE:
                    Log.d("bb", "鼠标移动");
                    break;
                case MotionEvent.ACTION_HOVER_EXIT:
                    Log.d("bb", "鼠标离开");
                    break;

                default:
                    break;
                }
                // TODO Auto-generated method stub
                return false;
            }
        });
    }
}
