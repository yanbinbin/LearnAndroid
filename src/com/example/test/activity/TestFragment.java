/**
 * Project Name:TestAndroidExample File Name:TestFragment.java Package
 * Name:com.example.test Date:2015-11-21 Copyright (c) 2015, www.meitu.com All
 * Rights Reserved.
 */

package com.example.test.activity;

import com.example.test.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ClassName: TestFragment <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-21
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class TestFragment extends Fragment {

    /*
     * (non-Javadoc)
     * @see android.app.Fragment#onCreateView(android.view.LayoutInflater,
     * android.view.ViewGroup, android.os.Bundle)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        return inflater.inflate(R.layout.fragment, container, false);
    }
}
