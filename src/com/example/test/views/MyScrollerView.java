/**
 * Project Name:TestAndroidExample File Name:MyView.java Package
 * Name:com.example.test.views Date:2015-12-23 Copyright (c) 2015, www.meitu.com
 * All Rights Reserved.
 */

package com.example.test.views;

import android.content.Context;
import android.util.AttributeSet;
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

}
