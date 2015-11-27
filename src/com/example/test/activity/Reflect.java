/**
 * Project Name:TestAndroidExample File Name:Reflect.java Package
 * Name:com.example.test.activity Date:2015-11-27 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.activity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.example.test.reflect.Demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * ClassName: Reflect <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-27
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class Reflect extends Activity {

    private static final String DEMO_PACKAGE = "com.example.test.reflect";

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // 反射调用无参构造函数
        // execNonParmConstructor();
        // 反射调用有参数的构造函数
//         execParamConstructor();
        // 获取所有接口
        // execInterface();
        // 获取父类
//        execSuperClass();
        // 获取属性
//        execField();
        // 执行方法
//        execInvokeMethod();
        // 设置属性
        execFieldAccess();
    }

    /**
     * execNonParmConstructor: 反射无参构造函数<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void execNonParmConstructor() {
        // TODO Auto-generated method stub
        try {
            Class<?> class1 = Class.forName(DEMO_PACKAGE + ".Demo");
            Class<Demo> class2 = Demo.class;
            Demo demo = new Demo();
            Class<? extends Demo> class3 = demo.getClass();

            Demo demo2 = (Demo)class1.newInstance();
            Demo demo3 = (Demo)class2.newInstance();
            Demo demo4 = (Demo)class3.newInstance();

            demo2.setAge(2);
            demo3.setAge(3);
            demo4.setAge(4);

            demo2.setName(class1.getSimpleName());
            demo3.setName(class2.getSimpleName());
            demo4.setName(class3.getSimpleName());

            demo2.toString();
            demo3.toString();
            demo4.toString();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * execParamConstructor: 获取有参构造函数<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void execParamConstructor() {
        // TODO Auto-generated method stub

        try {
            Class<?> class1 = Class.forName(DEMO_PACKAGE + ".Demo");
            Constructor<?>[] constructor = class1.getConstructors();
            Constructor<?>[] deConstructors = class1.getDeclaredConstructors();
            Log.d("bb", "public构造函数: " + constructor.length);
            Log.d("bb", "总共的构造: " + deConstructors.length);
            for (Constructor<?> constructor2 : deConstructors) {
                Log.d("bb", "构造函数:" + constructor2);
            }

            Demo demo1 = null;
            Demo demo2 = null;
            Demo demo3 = null;
            Demo demo4 = null;

            demo1 = (Demo)deConstructors[0].newInstance();
            demo2 = (Demo)deConstructors[1].newInstance(111);
            demo3 = (Demo)deConstructors[2].newInstance("aaa");
            demo4 = (Demo)deConstructors[3].newInstance("bbb", 122);

            demo1.toString();
            demo2.toString();
            demo3.toString();
            demo4.toString();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            Log.d("bb", e.toString());
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            Log.d("bb", e.toString());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            Log.d("bb", e.toString());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            Log.d("bb", e.toString());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            Log.d("bb", e.toString());
            e.printStackTrace();
        }

    }

    /**
     * execInterface: 反射实现的接口<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void execInterface() {
        // TODO Auto-generated method stub
        try {
            Class<?> class1 = Class.forName(DEMO_PACKAGE + ".Demo");
            Class<?>[] interfaces = class1.getInterfaces();
            for (Class<?> class2 : interfaces) {
                Log.d("bb", "实现的接口:" + class2.getName());
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * execSuperClass: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void execSuperClass() {
        // TODO Auto-generated method stub
        try {
            Class<?> class1 = Class.forName(DEMO_PACKAGE + ".Demo");
            Class<?> superClasses = class1.getSuperclass();
            Log.d("bb", "继承的父类: " + superClasses.getName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * execField: TODO<br/> 
     * 
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     *  
     * 
     */
    private void execField() {
        // TODO Auto-generated method stub
        try {
            Class<?> class1 = Class.forName(DEMO_PACKAGE + ".Demo");
            Log.d("bb", "本类中的属性: =====================");
            Field[] fields = class1.getDeclaredFields();
            for (Field field : fields) {
                // 权限修饰符
                int mo = field.getModifiers();
                String priv = Modifier.toString(mo);
                // 属性类型
                Class<?> type = field.getType();
                Log.d("bb", priv + type.getName() + field.getName());
            }
            Log.d("bb", "实现的接口或者父类中的属性==============");
            Field[] fields2 = class1.getFields();
            for (Field field : fields2) {
                // 权限修饰符
                int mo = field.getModifiers();
                String priv = Modifier.toString(mo);
                // 属性类型
                Class<?> type = field.getType();
                Log.d("bb", priv + type.getName() + field.getName());
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * execInvokeMethod: TODO<br/> 
     * 
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     *  
     * 
     */
    private void execInvokeMethod() {
        // TODO Auto-generated method stub
        try {
            Class<?> class1 = Class.forName(DEMO_PACKAGE + ".Demo");
            Method method = class1.getMethod("sayChina");
            method.invoke(class1.newInstance());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * execFieldAccess: TODO<br/> 
     * 
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     *  
     * 
     */
    private void execFieldAccess() {
        // TODO Auto-generated method stub
        try {
            Class<?> class1 = Class.forName(DEMO_PACKAGE + ".Demo");
            Field field = class1.getDeclaredField("name");
            field.setAccessible(true);
            Object object = class1.newInstance();
            field.set(object, "adad");
            Log.d("bb", "" + field.get(object));
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
