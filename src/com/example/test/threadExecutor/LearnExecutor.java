/**
 * Project Name:TestAndroidExample
 * File Name:LearnExecutor.java
 * Package Name:com.example.test.threadExecutor
 * Date:2016-1-5
 * Copyright (c) 2016, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.threadExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

/**
 * ClassName: LearnExecutor <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2016-1-5
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class LearnExecutor extends Activity {

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // 串行执行
        /*new MyAsyncTask("线程1").execute();
        new MyAsyncTask("线程2").execute();
        new MyAsyncTask("线程3").execute();
        new MyAsyncTask("线程4").execute();
        new MyAsyncTask("线程5").execute();*/
        // 并行执行
        /*new MyAsyncTask("线程1").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        new MyAsyncTask("线程2").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        new MyAsyncTask("线程3").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        new MyAsyncTask("线程4").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        new MyAsyncTask("线程5").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);*/
        // 测试IntentService
        /*Intent intent = new Intent(LearnExecutor.this, MyIntentService.class);
        intent.setAction("aaa");
        startService(intent);
        intent.setAction("bbb");
        startService(intent);
        intent.setAction("com.bb.test.action.INTENTSERVICE");
        startService(intent);*/
        // 测试线程池
        testThreadExecutor();
    }

    private void testThreadExecutor() {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Runnable command = new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Log.d("bb", "执行任务:" + dateFormat.format(new Date()));
                SystemClock.sleep(1000);
                Log.d("bb", "执行完成:" + dateFormat.format(new Date()));
            }
        };

        /**
         * FixedThreadPool：它是一种线程数量固定的线程池，当线程处于空闲状态时，它们不会被回收，除非线程池被关闭了。
         * 当所有的线程都处于活动状态时，新的任务都会处于等待状态，直到有线程空闲下来。由于FixedThreadPool只有核心
         * 线程且这些核心线程不会被回收，这意味着它能够更快的响应外界的请求。
         */
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
//        for (int i = 0; i < 5; i++) {
//            fixedThreadPool.execute(command);
//        }
        /**
         * CachedThreadPool:是一种线程数不定的线程池，它只有非核心线程，并且其最大的线程数为Integer.MAX_VALUE。（理论值，根据具体机器的虚拟机允许的最大线程数决定）
         * 当线程池中的线程都处于活动状态时，会创建新的线程来处理任务，否则就会利用空闲的线程来处理新的任务。
         * 线程池的空闲线程都有超时机制，这个超时时间为60秒，超过60秒的闲置线程就会被回收。
         * 适合作为执行大量的耗时较少的任务。
         */
//        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            cacheThreadPool.execute(command);
//        }
        /**
         * ScheduleThreadPool:它的核心线程是固定的，而非核心线程数是没有限制的，并且当非核心线程闲置时会被立即回收。
         * 主要用于执行定时任务和具有固定周期的重复任务
         */
//        ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(4);
//        // 2000ms后执行
//        scheduleThreadPool.schedule(command, 2000, TimeUnit.MILLISECONDS);
//        // 延迟100ms后，每隔1000ms执行一次
//        scheduleThreadPool.scheduleAtFixedRate(command, 100, 1000, TimeUnit.MILLISECONDS);
        /**
         * SingleThreadExecutor:只有一个核心线程，它确保所有的任务都在同一个线程中按顺序执行。
         * 意义在于统一所有的外界任务到一个线程中，使得这些任务之间不需要处理线程同步问题
         */
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 4; i++) {
            singleThreadPool.execute(command);
        }
    }
}
