/**
 * Project Name:TestAndroidExample File Name:BitmapDecoder.java Package
 * Name:com.example.test.bitmapcache Date:2016-1-6 Copyright (c) 2016,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.bitmapcache;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

/**
 * ClassName: BitmapDecoder <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2016-1-6
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class BitmapDecoder {

    public static Bitmap decodeSampleBitmapFromResource(Resources res,
            int resId, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth,
                reqHeight);
        Log.d("bb", "采样率为：" + options.inSampleSize);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    /**
     * calculateInSampleSize: 计算采样率<br/>
     * 
     * @author meitu.yanbb
     * @param options
     * @param reqWidth
     * @param reqHeight
     * @return
     * @since MT 1.0
     */
    public static int calculateInSampleSize(BitmapFactory.Options options,
            int reqWidth, int reqHeight) {
        final int width = options.outWidth;
        final int height = options.outHeight;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
