/**
 * Project Name:TestAndroidExample File Name:MySerializable.java Package
 * Name:com.example.test.serializable Date:2015-12-16 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.serializable;

import java.io.Serializable;

/**
 * ClassName: MySerializable <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-16
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class MySerializable implements Serializable {

    /**
     * serialVersionUID:TODO
     * 
     * @since MT 1.0
     */
    private static final long serialVersionUID = 1L;

    String name;
    String sex;
    int age;

    /**
     * 
     */
    public MySerializable() {
        // TODO Auto-generated constructor stub
    }

    public MySerializable(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
