/**
 * Project Name:TestAndroidExample
 * File Name:TestSerializableAndParcelable.java
 * Package Name:com.example.test.activity
 * Date:2015-12-16
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.example.test.R.layout;
import com.example.test.serializable.MyParcelable;
import com.example.test.serializable.MySerializable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * ClassName: TestSerializableAndParcelable <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-12-16
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class TestSerializableAndParcelable extends Activity {
    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        
//        serializedObject();
        MyParcelable parcelable = new MyParcelable("aa", "bb", 11);
        Intent intent =  new Intent();
        intent.putExtra("aa", parcelable);
        Bundle bundle =  new Bundle();
        bundle.putParcelable("bb", parcelable);
        MyParcelable parcelable2 = (MyParcelable)intent.getParcelableExtra("aa");
        Log.d("bb", "intent: " + parcelable2.getName() + "; " + parcelable2.getSex() + "; " + parcelable2.getAge());
        MyParcelable parcelable3 = (MyParcelable)bundle.getParcelable("bb");
        Log.d("bb", "bundle: " + parcelable3.getName() + "; " + parcelable3.getSex() + "; " + parcelable3.getAge());
    }

    /**
     * 
     * serializedObject: 序列化对象并保存在文件中<br/> 
     * 
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     *  
     *
     */
    private void serializedObject() {
//        MySerializable mySerializable = new MySerializable("IYun1025", "male", 22);
        MyParcelable mySerializable = new MyParcelable("IYun1025", "male", 22);
        ObjectOutputStream objectOutputStream ;
        try {
            Log.d("bb", "开始序列化。。。保存地址为:" + getCacheDir().getAbsolutePath());
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(getCacheDir().getAbsolutePath() + File.separator + "mySerializable.txt"));
            objectOutputStream.writeObject(mySerializable);
            objectOutputStream.close();
            Log.d("bb", "序列化OK。。。");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
