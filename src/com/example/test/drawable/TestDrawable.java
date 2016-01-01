/**
 * Project Name:TestAndroidExample
 * File Name:TestDrawable.java
 * Package Name:com.example.test.drawable
 * Date:2016-1-1
 * Copyright (c) 2016, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.drawable;

import com.example.test.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * ClassName: TestDrawable <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2016-1-1
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class TestDrawable extends Activity implements OnClickListener{
    Button mShowBitmapDrawable;
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test_drawable);
        mShowBitmapDrawable = (Button) findViewById(R.id.bitmap_drawable);
        mShowBitmapDrawable.setOnClickListener(this);
    }
    /* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent intent = new Intent(TestDrawable.this, ShowDrawable.class);
        switch (v.getId()) {
        case R.id.bitmap_drawable:
            intent.setFlags(0);
            break;

        default:
            break;
        }
        startActivity(intent);
    }

}
