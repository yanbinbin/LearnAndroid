/**
 * Project Name:TestAndroidExample
 * File Name:MySurfaceViewVideo.java
 * Package Name:com.example.test.surfaceview
 * Date:2015-11-30
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.surfaceview;

import java.io.File;
import java.io.IOException;

import com.example.test.R;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * ClassName: MySurfaceViewVideo <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-11-30
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class MySurfaceViewVideoActivity extends Activity {
    private EditText filenamEditText;
    private MediaPlayer mediaPlayer;
    private String filename;
    private SurfaceView surfaceView;
    private final static String TAG="VodeoPlayActivity";
    private int prosition=0;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_video);
        filenamEditText=(EditText) this.findViewById(R.id.filename);
        surfaceView=(SurfaceView)this.findViewById(R.id.surfaceview);
        surfaceView.getHolder().setFixedSize(400, 400); // 设置分辨率
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS); // 设置surfaceview不维护自己的缓冲区.而是等待屏幕的渲染引擎将内容推送到用户前面
        surfaceView.getHolder().addCallback(new SurceCallBack());
        mediaPlayer=new MediaPlayer();

        
        ButtonOnClikListiner buttonOnClikListinero=new ButtonOnClikListiner();
        Button start=(Button) this.findViewById(R.id.play);
        Button pause=(Button) this.findViewById(R.id.pause);
        Button stop=(Button) this.findViewById(R.id.stop);
        Button replay=(Button) this.findViewById(R.id.reset);
        start.setOnClickListener(buttonOnClikListinero);
        pause.setOnClickListener(buttonOnClikListinero);
        stop.setOnClickListener(buttonOnClikListinero);
        replay.setOnClickListener(buttonOnClikListinero);
    }

    private final class ButtonOnClikListiner implements OnClickListener{
        @Override
        public void onClick(View v) {
            if(Environment.getExternalStorageState()==Environment.MEDIA_UNMOUNTED){
                Toast.makeText(MySurfaceViewVideoActivity.this, "sd卡不存在", Toast.LENGTH_SHORT).show();
                return;
            }
            filename=filenamEditText.getText().toString();
            switch (v.getId()) {
            case R.id.play:
                play();
                break;
            case R.id.pause:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }else{
                    mediaPlayer.start();
                }
                break;
            case R.id.reset:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(0);
                }else{
                    play();
                }
                break;
            case R.id.stop:
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                break;
            }
        }  
    }

    /**
     * play: TODO<br/> 
     * 
     * 
     * @author meitu.yanbb
     * @since MT 1.0
     *  
     * 
     */
    private void play() {
        // TODO Auto-generated method stub
        try {
            File file = new File(Environment.getExternalStorageDirectory(), filename);
            mediaPlayer.reset(); // 重置为初始状态
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); // 设置音乐流的类型
            mediaPlayer.setDisplay(surfaceView.getHolder()); // 设置video以surfaceview播放
            mediaPlayer.setDataSource(file.getAbsolutePath()); // 设置播放路径
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IllegalArgumentException e) {
            Log.e("bb", e.toString());
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            Log.e("bb", e.toString());
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            Log.e("bb", e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Log.e("bb", e.toString());
            e.printStackTrace();
        }
    }

    private final class SurceCallBack implements SurfaceHolder.Callback{

        /* (non-Javadoc)
         * @see android.view.SurfaceHolder.Callback#surfaceCreated(android.view.SurfaceHolder)
         */
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            // TODO Auto-generated method stub
            if(prosition>0&&filename!=null){
                play();
                mediaPlayer.seekTo(prosition);
                prosition=0;
            }
        }

        /* (non-Javadoc)
         * @see android.view.SurfaceHolder.Callback#surfaceChanged(android.view.SurfaceHolder, int, int, int)
         */
        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                int height) {
            // TODO Auto-generated method stub
            
        }

        /* (non-Javadoc)
         * @see android.view.SurfaceHolder.Callback#surfaceDestroyed(android.view.SurfaceHolder)
         */
        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            // TODO Auto-generated method stub
            if(mediaPlayer.isPlaying()){
                prosition=mediaPlayer.getCurrentPosition();
                mediaPlayer.stop();
            }
        }
    }

}
