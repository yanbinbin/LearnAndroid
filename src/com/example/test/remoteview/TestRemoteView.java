/**
 * Project Name:TestAndroidExample File Name:TestRemoteView.java Package
 * Name:com.example.test.remoteview Date:2015-12-31 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.remoteview;

import com.example.test.R;
import com.example.test.activity.MainActivity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;

/**
 * ClassName: TestRemoteView <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-31
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class TestRemoteView extends Activity implements OnClickListener {

    Button mDefaultNotify;
    Button mRemoteNotify;
    Button mRemoteAppWidget;

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test_remote_view);
        mDefaultNotify = (Button)findViewById(R.id.notify_default);
        mDefaultNotify.setOnClickListener(this);
        mRemoteNotify = (Button)findViewById(R.id.notify_remoteview);
        mRemoteNotify.setOnClickListener(this);
        mRemoteAppWidget = (Button)findViewById(R.id.show_remoteview);
        mRemoteAppWidget.setOnClickListener(this);
    }

    /*
     * (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
        case R.id.notify_default:
            showDefaultNotify(this);
            break;
        case R.id.notify_remoteview:
            showRemoteNotify(this);
            break;
        case R.id.show_remoteview:
            break;

        default:
            break;
        }
    }

    /**
     * showDefaultNotify: 显示默认通知<br/>
     * 
     * @author meitu.yanbb
     * @param context
     * @since MT 1.0
     */
    @SuppressWarnings("deprecation")
    private void showDefaultNotify(Context context) {
        Notification notification = new Notification();
        notification.icon = R.drawable.android;
        notification.tickerText = "默认通知";
        notification.when = System.currentTimeMillis();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        Intent intent = new Intent(context, TestRemoteView.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setLatestEventInfo(context, "标题", "内容", pendingIntent);
        NotificationManager notificationManager = (NotificationManager)context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    /**
     * showRemoteNotify: 显示RemoteView通知<br/>
     * 
     * @author meitu.yanbb
     * @param context
     * @since MT 1.0
     */
    private void showRemoteNotify(Context context) {
        Notification notification = new Notification();
        notification.icon = R.drawable.android;
        notification.tickerText = "默认通知";
        notification.when = System.currentTimeMillis();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        Intent intent = new Intent(context, TestRemoteView.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews remoteViews = new RemoteViews(getPackageName(),
                R.layout.layout_notify);
        remoteViews.setTextViewText(R.id.msg, "RemoteView通知测试标题");
        remoteViews.setImageViewResource(R.id.icon, R.drawable.android);
        PendingIntent openIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, MainActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.content, openIntent);
        // notification.contentIntent = pendingIntent;
        notification.contentView = remoteViews;
        NotificationManager notificationManager = (NotificationManager)context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(2, notification);
    }

    
}
