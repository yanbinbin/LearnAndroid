/**
 * Project Name:TestAndroidExample File Name:MyAppWidgetProvider.java Package
 * Name:com.example.test.remoteview Date:2015-12-31 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.remoteview;

import com.example.test.R;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * ClassName: MyAppWidgetProvider <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-31
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class MyAppWidgetProvider extends AppWidgetProvider {

    public static final String ACTION_CLICK = "com.bb.test.action.CLICK";

    /**
     * 
     */
    public MyAppWidgetProvider() {
        // TODO Auto-generated constructor stub
        super();
    }

    /*
     * (non-Javadoc)
     * @see
     * android.appwidget.AppWidgetProvider#onReceive(android.content.Context,
     * android.content.Intent)
     */
    @Override
    public void onReceive(final Context context, Intent intent) {
        // TODO Auto-generated method stub
        super.onReceive(context, intent);
        Log.d("bb", "onReceive: action = " + intent.getAction());

        if (intent.getAction().equals(ACTION_CLICK)) {
            Toast.makeText(context, "点击了桌面小工具", Toast.LENGTH_SHORT).show();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    Bitmap bitmap = BitmapFactory.decodeResource(
                            context.getResources(), R.drawable.android);
                    AppWidgetManager manager = AppWidgetManager
                            .getInstance(context);
                    for (int i = 0; i < 37; i++) {
                        float degree = (i * 10) % 360;
                        RemoteViews remoteViews = new RemoteViews(context
                                .getPackageName(), R.layout.layout_widget);
                        remoteViews.setImageViewBitmap(R.id.icon,
                                rotateBitmap(context, bitmap, degree));
                        Intent intent = new Intent();
                        intent.setAction(ACTION_CLICK);
                        PendingIntent pendingIntent = PendingIntent
                                .getBroadcast(context, 0, intent, 0);
                        remoteViews.setOnClickPendingIntent(R.id.icon,
                                pendingIntent);
                        manager.updateAppWidget(new ComponentName(context,
                                MyAppWidgetProvider.class), remoteViews);
                        SystemClock.sleep(30);
                    }
                }
            }).start();
        }
    }

    /**
     * 每次桌面小部件更新都调用一次该方法
     */
    /*
     * (non-Javadoc)
     * @see
     * android.appwidget.AppWidgetProvider#onUpdate(android.content.Context,
     * android.appwidget.AppWidgetManager, int[])
     */
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager,
            int[] appWidgetIds) {
        // TODO Auto-generated method stub
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.d("bb", "onUpdate() ..");
        final int counter = appWidgetIds.length;
        Log.d("bb", "counter = " + counter);
        for (int i = 0; i < counter; i++) {
            int appWidgetId = appWidgetIds[i];
            onWidgetUpdate(context, appWidgetManager, appWidgetId);
        }
    }

    /**
     * onWidgetUpdate: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void onWidgetUpdate(Context context, AppWidgetManager manager,
            int appWidgetId) {
        // TODO Auto-generated method stub
        Log.d("bb", "onWidgetUpdate(): appWidgetId = " + appWidgetId);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.layout_widget);
        // 桌面小部件点击事件发生的intent广播
        Intent intent = new Intent();
        intent.setAction(ACTION_CLICK);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0,
                intent, 0);
        remoteViews.setOnClickPendingIntent(R.id.icon, pendingIntent);
        /**
         * 注释掉remoteview设置的全部不会生效
         */
        manager.updateAppWidget(appWidgetId, remoteViews);
    }

    /**
     * rotateBitmap: TODO<br/>
     * 
     * @author meitu.yanbb
     * @param context
     * @param srcBitmap
     * @param degree
     * @return
     * @since MT 1.0
     */
    private Bitmap rotateBitmap(Context context, Bitmap srcBitmap, float degree) {
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(degree);
        Bitmap targetBitmap = Bitmap.createBitmap(srcBitmap, 0, 0,
                srcBitmap.getWidth(), srcBitmap.getHeight(), matrix, true);
        return targetBitmap;
    }

    /*
     * (non-Javadoc)
     * @see
     * android.appwidget.AppWidgetProvider#onEnabled(android.content.Context)
     */
    @Override
    public void onEnabled(Context context) {
        // TODO Auto-generated method stub
        super.onEnabled(context);
        Log.d("bb", "onEnabled()...");
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // TODO Auto-generated method stub
        super.onDeleted(context, appWidgetIds);
        Log.d("bb", "onDeleted()...");
    }

    @Override
    public void onDisabled(Context context) {
        // TODO Auto-generated method stub
        super.onDisabled(context);
        Log.d("bb", "onDisabled()...");
    }

    @Override
    public void onRestored(Context context, int[] oldWidgetIds,
            int[] newWidgetIds) {
        // TODO Auto-generated method stub
        super.onRestored(context, oldWidgetIds, newWidgetIds);
        Log.d("bb", "onRestored()...");
    }

}
