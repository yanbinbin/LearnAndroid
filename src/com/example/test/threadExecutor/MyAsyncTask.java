/**
 * Project Name:TestAndroidExample File Name:MyAsyncTask.java Package
 * Name:com.example.test.threadExecutor Date:2016-1-5 Copyright (c) 2016,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.threadExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.AsyncTask;
import android.util.Log;

/**
 * ClassName: MyAsyncTask <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2016-1-5
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class MyAsyncTask extends AsyncTask<String, Integer, String> {
    private String mName = "MySayncTask";

    public MyAsyncTask(String name) {
        mName = name;
    }

    /*
     * (non-Javadoc)
     * @see android.os.AsyncTask#doInBackground(Params[])
     */
    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mName;
    }

    /*
     * (non-Javadoc)
     * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
     */
    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Log.d("bb", result + "在" + dateFormat.format(new Date()) + "执行完毕！");
    }

}
