/**
 * Project Name:TestAndroidExample
 * File Name:LearnExecutor.java
 * Package Name:com.example.test.threadExecutor
 * Date:2016-1-5
 * Copyright (c) 2016, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.threadExecutor;

import android.app.Activity;
import android.os.Bundle;

/**
 * ClassName: LearnExecutor <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2016-1-5
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class LearnExecutor extends Activity {

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        new MyAsyncTask("线程1").execute();
        new MyAsyncTask("线程2").execute();
        new MyAsyncTask("线程3").execute();
        new MyAsyncTask("线程4").execute();
        new MyAsyncTask("线程5").execute();
    }
}
