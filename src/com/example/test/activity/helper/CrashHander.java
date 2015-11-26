/**
 * Project Name:TestAndroidExample File Name:CrashHander.java Package
 * Name:com.example.test Date:2015-11-25 Copyright (c) 2015, www.meitu.com All
 * Rights Reserved.
 */

package com.example.test.activity.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * ClassName: CrashHander <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-25
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class CrashHander implements UncaughtExceptionHandler {
    public static final String LOG_TAG = "bb";

    // 系统默认的UncaughtException处理类
    private Thread.UncaughtExceptionHandler mExceptionHandler;

    private Context mContext;
    // 用来存储设备信息和异常信息
    private Map<String, String> mInfos = new HashMap<String, String>();
    // 用于时间格式
    private DateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-SS");
    // 单例模式
    private static CrashHander INSTANCE = new CrashHander();

    /**
     * 
     */
    public CrashHander() {
        // TODO Auto-generated constructor stub
    }

    public static CrashHander getInstance() {
        return INSTANCE;
    }

    /**
     * init: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    public void init(Context context) {
        // TODO Auto-generated method stub

        mContext = context;
        // 获取系统默认的UncaughtException处理器
        mExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(CrashHander.this);
    }

    /*
     * (non-Javadoc)
     * @see
     * java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang
     * .Thread, java.lang.Throwable)
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        // TODO Auto-generated method stub
        if (!handleException(ex) && mExceptionHandler != null) {
            mExceptionHandler.uncaughtException(thread, ex);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Log.e(LOG_TAG, "error : ", e);
            }
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

    /**
     * handleException: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private boolean handleException(Throwable ex) {
        // TODO Auto-gen erated method stub
        if (ex == null) {
            return false;
        }
        new Thread() {
            public void run() {
                Looper.prepare();
                Toast.makeText(mContext, "程序出现异常!", Toast.LENGTH_SHORT).show();
                Looper.loop();
            };
        }.start();
        // 收集设备参数信息
        collectDeviceInfo(mContext);
        // 保存日志文件
        saveCrashInfo2File(ex);
        return true;

    }

    /**
     * saveCrashInfo2File: TODO<br/>
     * 
     * @author meitu.yanbb
     * @param ex
     * @since MT 1.0
     */
    private void saveCrashInfo2File(Throwable ex) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : mInfos.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key + " = " + value + "\n");
        }

        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);

        Throwable throwable = ex.getCause();
        while (throwable != null) {
            throwable.printStackTrace(printWriter);
            throwable = throwable.getCause();
        }

        printWriter.close();

        sb.append(writer.toString());

        
        try {
            long timaStamp = System.currentTimeMillis();

            String time = mDateFormat.format(new Date());

            String fileName = "crash-" + getAppName(mContext) + "-" + time + "-" + timaStamp + ".txt";
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                Log.d(LOG_TAG, "sd卡根目录:" + Environment.getExternalStorageDirectory());
                String path = Environment.getExternalStorageDirectory() + "/crashInfo/";
                File file = new File(path);
                Log.d(LOG_TAG, file.getAbsolutePath() + " 存在? " + file.exists());
                if (!file.exists()) {
                    file.mkdirs();
                }
                String value = new String(new String(path + fileName).getBytes(),"utf-8"); 
                Log.d(LOG_TAG, file.getAbsolutePath() + " 创建成功? " + file.exists());
                Log.d(LOG_TAG, "开始保存日志");
                FileOutputStream outputStream = new FileOutputStream(value);
                outputStream.write(sb.toString().getBytes());
                outputStream.close();
                Log.d(LOG_TAG, "日志保存成功");
            }
        } catch (Exception e) {
            // TODO: handle exception
            Log.e(LOG_TAG, "保存日志出现异常:" + e.toString());
        }
    }

    /**
     * collectDeviceInfo: 收集设备参数<br/>
     * 
     * @author meitu.yanbb
     * @param mContext2
     * @since MT 1.0
     */
    private void collectDeviceInfo(Context context) {
        // TODO Auto-generated method stub
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(
                    context.getPackageName(), PackageManager.GET_ACTIVITIES);
            if (packageInfo != null) {
                String versionName = packageInfo.versionName == null ? "null"
                        : packageInfo.versionName;
                String versionCode = packageInfo.versionCode + "";
                mInfos.put("versionName", versionName);
                mInfos.put("versionCode", versionCode);
            }
        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                mInfos.put(field.getName(), field.get(null).toString());
                Log.d(LOG_TAG, "设备信息:" + field.getName() + " = " + field.get(null).toString());
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    /**
     * getAppName: TODO<br/> 
     * 
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     *  
     * 
     */
    private String getAppName(Context context) {
        // TODO Auto-generated method stub
        String appName = "";
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo info = packageManager.getApplicationInfo(context.getPackageName(), 0);
            appName = (String)packageManager.getApplicationLabel(info);
        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return appName;
    }
}
