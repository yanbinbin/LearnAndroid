/**
 * Project Name:TestAndroidExample
 * File Name:MyStockIndicatorView.java
 * Package Name:com.example.test.surfaceview
 * Date:2015-11-30
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff.Mode;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * ClassName: MyStockIndicatorView <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-11-30
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class MyStockIndicatorView extends SurfaceView implements SurfaceHolder.Callback{
    Paint mPaint;
    SurfaceHolder mHolder;
    float currentX;
    /**
     * 
     */
    public MyStockIndicatorView(Context context) {
        super(context);
        mHolder = getHolder();
        mHolder.addCallback(this);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);

        mHolder.setFormat(PixelFormat.TRANSPARENT);
        setZOrderOnTop(true);

        setFocusable(true);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see android.view.View#onTouchEvent(android.view.MotionEvent)
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        int eventaction = event.getAction();
        int x = (int)event.getX();
        switch (eventaction) {
        case MotionEvent.ACTION_DOWN:
        case MotionEvent.ACTION_MOVE:
            currentX = x;
            clearCavas();
            paintIndicator();
            break;
        case MotionEvent.ACTION_UP:
        case MotionEvent.ACTION_CANCEL:
            clearCavas();
            break;

        default:
            break;
        }
        return true;
    }
    /**
     * clearCavas: TODO<br/> 
     * 
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     *  
     * 
     */
    private void clearCavas() {
        // TODO Auto-generated method stub
        Canvas canvas = mHolder.lockCanvas();
        canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);
        mHolder.unlockCanvasAndPost(canvas);
    }

    /**
     * paintIndicator: TODO<br/> 
     * 
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     *  
     * 
     */
    private void paintIndicator() {
        // TODO Auto-generated method stub
        Canvas canvas = mHolder.lockCanvas();
        canvas.drawColor(Color.TRANSPARENT, Mode.CLEAR);
        canvas.drawLine(currentX , 0, currentX, getHeight(), mPaint);
        mHolder.unlockCanvasAndPost(canvas);
    }

    /* (non-Javadoc)
     * @see android.view.SurfaceHolder.Callback#surfaceCreated(android.view.SurfaceHolder)
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see android.view.SurfaceHolder.Callback#surfaceChanged(android.view.SurfaceHolder, int, int, int)
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
            int height) {
        // TODO Auto-generated method stub
        
    }

    /* (non-Javadoc)
     * @see android.view.SurfaceHolder.Callback#surfaceDestroyed(android.view.SurfaceHolder)
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        
    }

}
