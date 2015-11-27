/**
 * Project Name:TestAndroidExample File Name:Proxy.java Package
 * Name:com.example.test.activity Date:2015-11-27 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.activity;

import com.example.test.proxy.BookImpl;
import com.example.test.proxy.BookImplNonMethod;
import com.example.test.proxy.BookProxy;
import com.example.test.proxy.BookProxyNonMethod;
import com.example.test.proxy.InterfaceBook;
import com.example.test.proxy.InterfaceBookNonMethod;

import android.app.Activity;
import android.os.Bundle;

/**
 * ClassName: Proxy <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-27
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class Proxy extends Activity {

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // 执行接口中有方法申明的代理
        BookProxy bookProxy = new BookProxy();
        InterfaceBook book = (InterfaceBook)bookProxy.bind(new BookImpl());
        book.addBook();
        // 执行只有标记接口没有方法申明的代理
        /**
         * 报错 类型不能强转
         */
        // BookProxyNonMethod bookProxyNonMethod = new BookProxyNonMethod();
        // BookImplNonMethod bookNonMethod =
        // (BookImplNonMethod)bookProxyNonMethod.bind(new BookImplNonMethod());
        // bookNonMethod.addBook();
    }
}
