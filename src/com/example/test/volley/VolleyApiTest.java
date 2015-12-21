/**
 * Project Name:TestAndroidExample File Name:ApiTest.java Package
 * Name:com.example.test.volley Date:2015-12-21 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.volley;

import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.test.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * ClassName: ApiTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-21
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class VolleyApiTest {

    private Context mContext;

    /**
     * 
     */
    public VolleyApiTest(Context context) {
        // TODO Auto-generated constructor stub
        mContext = context;
    }

    public RequestQueue getRequestQueue() {
        return Volley.newRequestQueue(mContext);
    }

    /**
     * testStringRequest: 测试StringRequest<br/>
     * 
     * @author meitu.yanbb
     * @param url
     * @param view
     * @since MT 1.0
     */
    public void testStringRequest(String url, final TextView view) {
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        // TODO Auto-generated method stub
                        view.setText("服务器返回数据：" + response);
                    }
                }, new ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        view.setText("错误信息为：" + error.getMessage());
                    }
                });
        RequestQueue requestQueue = getRequestQueue();
        requestQueue.add(stringRequest);
    }

    // http://ditu.amap.com/service/pl/pl.json?rand=635840524184357321
    public void testJsonRequest(String url, final TextView view) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // TODO Auto-generated method stub
                        view.setText("服务器返回数据：" + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        error.printStackTrace();
                        view.setText("错误信息为：" + error.getMessage());
                    }
                });
        RequestQueue requestQueue = getRequestQueue();
        requestQueue.add(jsonObjectRequest);
    }

    /**
     * testImageRequest: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    public void testImageRequest(String url, final ImageView view) {
        // TODO Auto-generated method stub
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {

                    @Override
                    public void onResponse(Bitmap response) {
                        // TODO Auto-generated method stub
                        view.setImageBitmap(response);
                    }
                }, 0, 0, Config.ARGB_8888, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        error.printStackTrace();
                    }
                });
        RequestQueue requestQueue = getRequestQueue();
        requestQueue.add(request);

    }

    /**
     * testImageLoader: 测试缓存，测试时可以第一次联网后续断网操作<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    public void testImageLoader(String url, final ImageView view) {
        // TODO Auto-generated method stub
        ImageLoader loader = new ImageLoader(getRequestQueue(),
                new BitmapCache());
        ImageListener listener = ImageLoader.getImageListener(view,
                R.drawable.loading, R.drawable.android);
        loader.get(url, listener);
    }

    /**
     * testNetworkImageView: TODO<br/> 
     * 
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     *  
     * 
     */
    public NetworkImageView testNetworkImageView(String url, Context context) {
        // TODO Auto-generated method stub
        ImageLoader loader = new ImageLoader(getRequestQueue(),
                new BitmapCache());
        NetworkImageView imageView = new NetworkImageView(context);
        imageView.setDefaultImageResId(R.drawable.loading);
        imageView.setErrorImageResId(R.drawable.android);
        imageView.setImageUrl(url, loader);
        return imageView;
    }
}
