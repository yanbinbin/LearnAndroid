/**
 * Project Name:TestAndroidExample
 * File Name:MyIntentService.java
 * Package Name:com.example.test.threadExecutor
 * Date:2016-1-5
 * Copyright (c) 2016, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.threadExecutor;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

/**
 * ClassName: MyIntentService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2016-1-5
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class MyIntentService extends IntentService {

    /**
     * @param name
     */
    public MyIntentService() {
        super("");
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see android.app.IntentService#onHandleIntent(android.content.Intent)
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        // TODO Auto-generated method stub
        String action = intent.getAction();
        Log.d("bb", "收到task：" + action);
        SystemClock.sleep(3000);
        if ("com.bb.test.action.INTENTSERVICE".equals(action)) {
            Log.d("bb", "处理:" + action);
        }
    }

    /* (non-Javadoc)
     * @see android.app.IntentService#onDestroy()
     */
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.d("bb", "服务销毁。。");
    }
}
