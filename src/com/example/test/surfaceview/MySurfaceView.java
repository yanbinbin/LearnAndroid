/**
 * Project Name:TestAndroidExample File Name:MyView.java Package
 * Name:com.example.test.surfaceview Date:2015-11-30 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.surfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * ClassName: MyView <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-30
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback,
        Runnable {
    SurfaceHolder mHolder;
    Paint mPaint;

    private int x, y;

    private boolean isRunning = true;

    /**
     * 
     */
    public MySurfaceView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        mHolder = getHolder();
        mHolder.addCallback(this);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);

        this.setFocusable(true);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (isRunning) {
            paint();
            move();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    /*
     * (non-Javadoc)
     * @see
     * android.view.SurfaceHolder.Callback#surfaceCreated(android.view.SurfaceHolder
     * )
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        Thread thread = new Thread(this);
        thread.start();

    }

    /*
     * (non-Javadoc)
     * @see
     * android.view.SurfaceHolder.Callback#surfaceChanged(android.view.SurfaceHolder
     * , int, int, int)
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
            int height) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see android.view.View#onDraw(android.graphics.Canvas)
     */
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        canvas = mHolder.lockCanvas();
        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(x, y, 20, mPaint);
        mHolder.unlockCanvasAndPost(canvas);
    }

    /**
     * paint: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void paint() {
        // TODO Auto-generated method stub
        Canvas canvas = mHolder.lockCanvas();
        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(x, y, 20, mPaint);
        mHolder.unlockCanvasAndPost(canvas);

    }

    /**
     * move: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void move() {
        // TODO Auto-generated method stub

        x += 2;
        y += 2;
    }

    /*
     * (non-Javadoc)
     * @see android.view.SurfaceHolder.Callback#surfaceDestroyed(android.view.
     * SurfaceHolder)
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        isRunning = false;

    }

}
