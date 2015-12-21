/**
 * Project Name:TestAndroidExample File Name:ImageCache.java Package
 * Name:com.example.test.volley Date:2015-12-21 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.volley;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

/**
 * ClassName: ImageCache <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-21
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class BitmapCache implements ImageCache {
    /**
     * 50Mb 最大缓存
     */
    private static final int MAX_CACHE_SIZE = 50 * 1024 * 1024;
    private LruCache<String, Bitmap> mCache;

    /**
     * 
     */
    public BitmapCache() {
        // TODO Auto-generated constructor stub
        mCache = new LruCache<String, Bitmap>(MAX_CACHE_SIZE) {
            /*
             * (non-Javadoc)
             * @see android.util.LruCache#sizeOf(java.lang.Object,
             * java.lang.Object)
             */
            @Override
            protected int sizeOf(String key, Bitmap value) {
                // TODO Auto-generated method stub
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    /*
     * (non-Javadoc)
     * @see
     * com.android.volley.toolbox.ImageLoader.ImageCache#getBitmap(java.lang
     * .String)
     */
    @Override
    public Bitmap getBitmap(String url) {
        // TODO Auto-generated method stub
        return mCache.get(url);
    }

    /*
     * (non-Javadoc)
     * @see
     * com.android.volley.toolbox.ImageLoader.ImageCache#putBitmap(java.lang
     * .String, android.graphics.Bitmap)
     */
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        // TODO Auto-generated method stub
        mCache.put(url, bitmap);
    }

}
