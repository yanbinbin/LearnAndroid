/**
 * Project Name:TestAndroidExample File Name:TestAnimation.java Package
 * Name:com.example.test.animation Date:2016-1-4 Copyright (c) 2016,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.animation;

import com.example.test.R;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * ClassName: TestAnimation <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2016-1-4
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class TestAnimation extends Activity {
    View mContent;
    ImageView mIcon;

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animation);
        mContent = (RelativeLayout)findViewById(R.id.content);
        mIcon = (ImageView)findViewById(R.id.icon);
        mIcon.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.d("bb", "click ..");
                testObjectAnimation(mIcon);
            }
        });
    }

    /**
     * testObjectAnimation: TODO<br/>
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     */
    private void testObjectAnimation(View target) {
        // TODO Auto-generated method stub
        // ObjectAnimator.ofFloat(target, "translationY",
        // -target.getHeight()).start();
        /**
         * 改变一个对象的的背景色属性，下面的动画是让背景色在3秒内从0xFFFF8080--->0xFF8080FF，动画会一直循环且反转的效果。
         */
        /*
         * ValueAnimator colorAnimator = ObjectAnimator.ofInt(target,
         * "backgroundColor", 0xFFFF8080, 0xFF8080FF);
         * colorAnimator.setDuration(3000); colorAnimator.setEvaluator(new
         * ArgbEvaluator());
         * colorAnimator.setRepeatCount(ValueAnimator.INFINITE);
         * colorAnimator.setRepeatMode(ValueAnimator.REVERSE);
         * colorAnimator.start();
         */
        /**
         * 动画集合
         */
        /**AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(target, "rotationX", 0, 360),
                ObjectAnimator.ofFloat(target, "rotationX", 0, 360),
                ObjectAnimator.ofFloat(target, "rotationY", 0, 180),
                ObjectAnimator.ofFloat(target, "rotation", 0, -90),
                ObjectAnimator.ofFloat(target, "translationX", 0, 90),
                ObjectAnimator.ofFloat(target, "translationY", 0, 90),
                ObjectAnimator.ofFloat(target, "scaleX", 1, 1.5f),
                ObjectAnimator.ofFloat(target, "scaleY", 1, 0.5f),
                ObjectAnimator.ofFloat(target, "alpha", 1, 0.25f, 1));
        set.setDuration(5000).start();**/
        /**
         * xml 的方式加载属性动画
         */
        /*AnimatorSet set = (AnimatorSet)AnimatorInflater.loadAnimator(TestAnimation.this, R.anim.anim_property_set);
        set.setTarget(target);
        set.start();*/
        /**
         * 包装类包装原始对象，间接提供get/set方法
         */
        ViewWrapper wrapper = new ViewWrapper(target);
        ObjectAnimator.ofInt(wrapper, "height", 500).setDuration(2000).start();
    }

    private static class ViewWrapper{
        private View mTarget;
        public ViewWrapper(View view) {
            mTarget = view;
        }
        public int getHeight() {
            return mTarget.getLayoutParams().height;
        }
        public void setHeight(int height) {
            mTarget.getLayoutParams().height = height;
            mTarget.requestLayout();
        }
    }

}
