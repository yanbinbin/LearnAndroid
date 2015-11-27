/**
 * Project Name:TestAndroidExample
 * File Name:BookImpl.java
 * Package Name:com.example.test.proxy
 * Date:2015-11-27
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.proxy;

import android.util.Log;

/**
 * ClassName: BookImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-11-27
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class BookImplNonMethod implements InterfaceBookNonMethod{

    /* (non-Javadoc)
     * @see com.example.test.proxy.InterfaceBook#addBook()
     */
    public void addBook() {
        // TODO Auto-generated method stub
        Log.d("bb", "BookImplNonMethod---> addBook() ...");
    }

}
