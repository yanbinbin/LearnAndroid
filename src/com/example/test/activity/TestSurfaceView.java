/**
 * Project Name:TestAndroidExample File Name:TestSurfaceView.java Package
 * Name:com.example.test.activity Date:2015-11-30 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.activity;

import com.example.test.R;
import com.example.test.surfaceview.MySurfaceView;
import com.example.test.surfaceview.MySurfaceViewActivity;
import com.example.test.surfaceview.MySurfaceViewVideoActivity;
import com.example.test.surfaceview.TestSurfaceviewDrawLine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * ClassName: TestSurfaceView <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-30
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class TestSurfaceView extends Activity implements OnClickListener {
    Button mTestSurface;
    Button mTestSurfaceVideo;
    Button mTestSurfaceDrawLine;

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface);
        mTestSurface = (Button)findViewById(R.id.surfaceview);
        mTestSurface.setOnClickListener(this);
        mTestSurfaceVideo = (Button)findViewById(R.id.surfaceview_video);
        mTestSurfaceVideo.setOnClickListener(this);
        mTestSurfaceDrawLine = (Button)findViewById(R.id.surfaceview_draw_line);
        mTestSurfaceDrawLine.setOnClickListener(this);
    }

    /*
     * (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
        case R.id.surfaceview:
            Intent intent = new Intent();
            intent.setClass(this, MySurfaceViewActivity.class);
            startActivity(intent);
            break;
        case R.id.surfaceview_video:
            Intent intent1 = new Intent();
            intent1.setClass(this, MySurfaceViewVideoActivity.class);
            startActivity(intent1);
            break;
        case R.id.surfaceview_draw_line:
            Intent intent2 = new Intent();
            intent2.setClass(this, TestSurfaceviewDrawLine.class);
            startActivity(intent2);
            break;

        default:
            break;
        }
    }
}
