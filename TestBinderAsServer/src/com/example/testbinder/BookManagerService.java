/**
 * Project Name:TestBinder
 * File Name:BookManagerService.java
 * Package Name:com.example.testbinder
 * Date:2015-12-18
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.testbinder;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import com.example.test.binder.Book;
import com.example.test.binder.IBookManager;
import com.example.test.binder.IOnNewBookArrivedListener;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

/**
 * ClassName: BookManagerService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-12-18
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class BookManagerService extends Service {

    private AtomicBoolean mIsServiceAlive = new AtomicBoolean(true);
    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<Book>();
    private RemoteCallbackList<IOnNewBookArrivedListener> mListeners = new RemoteCallbackList<IOnNewBookArrivedListener>();

    private Binder mBinder = new IBookManager.Stub() {
        
        @Override
        public List<Book> getBookList() throws RemoteException {
            // TODO Auto-generated method stub
            return mBookList;
        }
        
        @Override
        public void addBook(Book book) throws RemoteException {
            // TODO Auto-generated method stub
            mBookList.add(book);
        }

        @Override
        public void registerListener(IOnNewBookArrivedListener listener)
                throws RemoteException {
            // TODO Auto-generated method stub
            mListeners.register(listener);
            Log.d("bb", "注册后监听对象：" + mListeners.getRegisteredCallbackCount());
        }

        @Override
        public void unRegisterListener(IOnNewBookArrivedListener listener)
                throws RemoteException {
            // TODO Auto-generated method stub
            mListeners.unregister(listener);
            Log.d("bb", "解注后监听对象：" + mListeners.getRegisteredCallbackCount());
        }
    };
    /* (non-Javadoc)
     * @see android.app.Service#onBind(android.content.Intent)
     */
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return mBinder;
    }

    /* (non-Javadoc)
     * @see android.app.Service#onCreate()
     */
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        mBookList.add(new Book("严彬彬", "男", 23));
        mBookList.add(new Book("胡显响", "男", 30));
        new Thread(new AutoAddBookWorker()).start();
    }

    /* (non-Javadoc)
     * @see android.app.Service#onDestroy()
     */
    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        mIsServiceAlive.set(false);
    }
    /**
     * onNewBookArrived: TODO<br/> 
     * 
     * 
     * @author meitu.yanbb
     * @throws RemoteException 
     * @since MT 1.0
     *  
     * 
     */
    private void onNewBookArrived(Book book) throws RemoteException {
        // TODO Auto-generated method stub
        mBookList.add(book);
        Log.d("bb", "新书到来，开始通知");
        final int size = mListeners.beginBroadcast();
        for (int i = 0; i < size; i++) {
            IOnNewBookArrivedListener listener = mListeners.getBroadcastItem(i);
            if (listener != null) {
                listener.onNewBookArrived(book);
            }
        }
        mListeners.finishBroadcast();

    }
    private class AutoAddBookWorker implements Runnable {

        /* (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (mIsServiceAlive.get()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                int bookId = mBookList.size() + 1;
                Book newBook = new Book("bin", "nan", bookId);
                try {
                    onNewBookArrived(newBook);
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
