/**
 * P * Project Name:TestAndroidExample File Name:Book.java Package
 * Name:com.example.test.proxy Date:2015-11-27 Copyright (c) 2015, www.meitu.com
 * All Rights Reserved.
 */

package com.example.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import android.util.Log;

/**
 * ClassName: Book <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-27
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class BookProxy implements InvocationHandler {
    private Object target;

    /**
     * bind: TODO<br/>
     * 绑定委托对象并返回一个代理类
     * 
     * @author meitu.yanbb
     * @return
     * @since MT 1.0
     */
    public Object bind(Object object) {
        // TODO Auto-generated method stub
        this.target = object;

        // 取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);

    }

    /*
     * (non-Javadoc)
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
     * java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // TODO Auto-generated method stub
        Object result = null;
        Log.d("bb", "开始执行...");
        result = method.invoke(target, args);
        Log.d("bb", "执行结束...");
        return null;
    }

}
