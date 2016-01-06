/**
 * Project Name:TestAndroidExample File Name:BitmapCache.java Package
 * Name:com.example.test.bitmapcache Date:2016-1-6 Copyright (c) 2016,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.bitmapcache;

import com.example.test.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

/**
 * ClassName: BitmapCache <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2016-1-6
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class BitmapCache extends Activity {

    ImageView mIconView;
    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bitmap_cache);
        mIconView = (ImageView) findViewById(R.id.icon);
        mIconView.setImageBitmap(BitmapDecoder.decodeSampleBitmapFromResource(getResources(), R.drawable.loading, 40, 40));
    }

}
