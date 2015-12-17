/**
 * Project Name:TestAndroidExample File Name:MyParcelable.java Package
 * Name:com.example.test.serializable Date:2015-12-17 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.serializable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * ClassName: MyParcelable <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-17
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class MyParcelable implements Parcelable {
    String name;
    String sex;
    int age;

    /**
     * 
     */
    public MyParcelable() {
        // TODO Auto-generated constructor stub
    }

    public MyParcelable(String name, String sex, int age) {
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

    /*
     * (non-Javadoc)
     * @see android.os.Parcelable#describeContents()
     */
    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // TODO Auto-generated method stub
        dest.writeString(name);
        dest.writeString(sex);
        dest.writeInt(age);
    }

    public static final Parcelable.Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {

        @Override
        public MyParcelable[] newArray(int size) {
            // TODO Auto-generated method stub
            return new MyParcelable[size];
        }

        @Override
        public MyParcelable createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new MyParcelable(source);
        }
    };

    private MyParcelable(Parcel in) {
        name = in.readString();
        sex = in.readString();
        age = in.readInt();
//        in.readParcelable(Thread.currentThread().getContextClassLoader());
    }
}
