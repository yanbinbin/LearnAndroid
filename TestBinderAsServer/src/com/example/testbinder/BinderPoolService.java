/**
 * Project Name:TestBinderAsServer
 * File Name:BinderPoolService.java
 * Package Name:com.example.testbinder
 * Date:2015-12-23
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.testbinder;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.example.test.binder.IBinderPoolImpl;

/**
 * ClassName: BinderPoolService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-12-23
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class BinderPoolService extends Service {
    private Binder mBinder = new IBinderPoolImpl();

    /* (non-Javadoc)
     * @see android.app.Service#onBind(android.content.Intent)
     */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        Log.d("bb", "BinderPoolService--->onBind()..");
        return mBinder;
    }

}
