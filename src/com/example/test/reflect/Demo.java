/**
 * Project Name:TestAndroidExample File Name:Demo.java Package
 * Name:com.example.test.reflect Date:2015-11-27 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.reflect;

import android.util.Log;

/**
 * ClassName: Demo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-27
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class Demo implements InterfaceDemo, InterfaceDemo2{

    private String name;
    private int age;

    /**
     * 
     */
    public Demo() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param name
     */
    public Demo(String name) {
        super();
        this.name = name;
    }

    /**
     * @param age
     */
    public Demo(int age) {
        super();
        this.age = age;
    }

    /**
     * @param name
     * @param age
     */
    public Demo(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        Log.d("bb", "[" + this.name + "  " + this.age + "]");
        return "";
    }

    /* (non-Javadoc)
     * @see com.example.test.reflect.InterfaceDemo#sayChina()
     */
    @Override
    public void sayChina() {
        // TODO Auto-generated method stub
        Log.d("bb", "[" + this.name + "  " + this.age + "] -----> China");
    }

    /* (non-Javadoc)
     * @see com.example.test.reflect.InterfaceDemo#sayHello(java.lang.String, int)
     */
    @Override
    public void sayHello(String name, int age) {
        // TODO Auto-generated method stub
        Log.d("bb", "[" + this.name + "  " + this.age + "] -----> hello");
    }

    /* (non-Javadoc)
     * @see com.example.test.reflect.InterfaceDemo2#sayEnglish()
     */
    @Override
    public void sayEnglish() {
        // TODO Auto-generated method stub
        
    }

}
