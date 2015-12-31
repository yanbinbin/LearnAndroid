/**
 * Project Name:TestAndroidExample
 * File Name:MyLinearLayout.java
 * Package Name:com.example.test.views
 * Date:2015-12-24
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * ClassName: MyLinearLayout <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-12-24
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */

public class MyLinearLayout extends RelativeLayout {

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    public MyLinearLayout(Context context, AttributeSet attrs,
            int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     * @param attrs
     */
    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param context
     */
    public MyLinearLayout(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     */
    /* (non-Javadoc)
     * @see android.view.ViewGroup#dispatchTouchEvent(android.view.MotionEvent)
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        Log.d("bb", "父控件dispatchTouchEvent(): " + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    /* (non-Javadoc)
     * @see android.view.ViewGroup#onInterceptTouchEvent(android.view.MotionEvent)
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        Log.d("bb", "父控件onInterceptTouchEvent(): " + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    /* (non-Javadoc)
     * @see android.view.View#onTouchEvent(android.view.MotionEvent)
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        Log.d("bb", "父控件onTouchEvent(): " + event.getAction());
        return super.onTouchEvent(event);
    }
}
