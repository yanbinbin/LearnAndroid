/**
 * Project Name:TestAndroidExample File Name:Fragment.java Package
 * Name:com.example.test Date:2015-11-21 Copyright (c) 2015, www.meitu.com All
 * Rights Reserved.
 */

package com.example.test.activity;

import com.example.test.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * ClassName: Fragment <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-11-21
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class Fragment extends Activity {

    TestFragment fragment;
    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        addFragment();
        Button backFragment = (Button) findViewById(R.id.button);
        backFragment.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.hide(fragment);
//                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    /**
     * addFragment: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void addFragment() {
        // TODO Auto-generated method stub

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

         fragment = new TestFragment();
//        transaction.add(fragment, "testFragment");
        transaction.add(R.id.fragment_container, fragment);
        transaction.commit();
    }
}
