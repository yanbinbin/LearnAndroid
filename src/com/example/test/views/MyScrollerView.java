/**
 * Project Name:TestAndroidExample File Name:MyView.java Package
 * Name:com.example.test.views Date:2015-12-23 Copyright (c) 2015, www.meitu.com
 * All Rights Reserved.
 */

package com.example.test.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * ClassName: MyScrollerView <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-23
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class MyScrollerView extends TextView {

    private Scroller mScroller;

    /**
     * @param context
     */
    public MyScrollerView(Context context) {
        super(context);
        mScroller = new Scroller(context);
        // TODO Auto-generated constructor stub
    }

    
    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    public MyScrollerView(Context context, AttributeSet attrs,
            int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mScroller = new Scroller(context);
        // TODO Auto-generated constructor stub
    }


    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
        // TODO Auto-generated constructor stub
    }


    /**
     * @param context
     * @param attrs
     */
    public MyScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
        // TODO Auto-generated constructor stub
    }


    /*
     * (non-Javadoc)
     * @see android.view.View#computeScroll()
     */
    @Override
    public void computeScroll() {
        // TODO Auto-generated method stub
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    public void smoothScrollTo(int destX, int destY) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int deltaX = destX - scrollX;
        mScroller.startScroll(scrollX, 0, deltaX, 0, 4000);
        invalidate();
    }

    /* (non-Javadoc)
     * @see android.view.View#dispatchTouchEvent(android.view.MotionEvent)
     * 默认会被拦截
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        Log.d("bb", "子类dispatchTouchEvent()：" + event.getAction());
        return super.dispatchTouchEvent(event);
    }

    /* (non-Javadoc)
     * @see android.widget.TextView#onTouchEvent(android.view.MotionEvent)
     * 默认会消费
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        Log.d("bb", "子类onTouchEvent()：" + event.getAction());
        return false;
    }

    /* (non-Javadoc)
     * @see android.widget.TextView#onMeasure(int, int)
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}
