/**
 * Project Name:TestAndroidExample File Name:MyParcelable.java Package
 * Name:com.example.test.serializable Date:2015-12-17 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.binder;

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
public class Book implements Parcelable {
    String name;
    String sex;
    int age;

    /**
     * 
     */
    public Book() {
        // TODO Auto-generated constructor stub
    }

    public Book(String name, String sex, int age) {
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

    public static final Parcelable.Creator<Book> CREATOR = new Creator<Book>() {

        @Override
        public Book[] newArray(int size) {
            // TODO Auto-generated method stub
            return new Book[size];
        }

        @Override
        public Book createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new Book(source);
        }
    };

    private Book(Parcel in) {
        name = in.readString();
        sex = in.readString();
        age = in.readInt();
//        in.readParcelable(Thread.currentThread().getContextClassLoader());
    }
}
