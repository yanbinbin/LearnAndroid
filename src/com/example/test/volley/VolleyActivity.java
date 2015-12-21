/**
 * Project Name:TestAndroidExample File Name:VolleyActivity.java Package
 * Name:com.example.test.volley Date:2015-12-21 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.volley;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ClassName: VolleyActivity <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-21
 * 
 * http://blog.csdn.net/guolin_blog/article/details/17482095#
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class VolleyActivity extends Activity {

    VolleyApiTest mApiTest;
    TextView info;
    ImageView mImageView;

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mApiTest = new VolleyApiTest(getApplication());
        info = new TextView(this);
        // setContentView(info);
        // mApiTest.testStringRequest("http://www.baidu.com", info);
        // mApiTest.testJsonRequest("http://ditu.amap.com/service/pl/pl.json?rand=635840524184357321",
        // info);
        mImageView = new ImageView(this);
        setContentView(mImageView);
//        mApiTest.testImageRequest(
//                "http://www.qqaiqin.com/uploads/allimg/130407/4-13040GA023A1.jpg",
//                mImageView);
        /*
         * 图片可以获取
         */
//        mApiTest.testImageLoader(
//                "http://www.qqaiqin.com/uploads/allimg/130407/4-13040GA023A1.jpg",
//                mImageView);
        /**
         * 图片不可获取
         */
//        mApiTest.testImageLoader(
//                "http://www.qqaiqin.com/uploads/allimg/130407/4-13040GA023A1a.jpg",
//                mImageView);
        /**
         * 测试Network
         */
        setContentView(mApiTest.testNetworkImageView("http://www.qqaiqin.com/uploads/allimg/130407/4-13040GA023A1.jpg", this));
    }
}
