/**
 * Project Name:TestBinderAsServer File Name:IBinderPoolImpl.java Package
 * Name:com.example.test.binder Date:2015-12-23 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.test.binder;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/**
 * ClassName: IBinderPoolImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Date:2015-12-23
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class IBinderPoolImpl extends IBinderPool.Stub {
    private static final int CODE_BINDER_PRINT = 1;
    private static final int CODE_BINDER_COMPUTE = 2;

    /*
     * (non-Javadoc)
     * @see com.example.test.binder.IBinderPool#queryBinder(int)
     */
    @Override
    public IBinder queryBinder(int binderCode) throws RemoteException {
        // TODO Auto-generated method stub
        Log.d("bb", "服务端queryBinder()被调用.");
        IBinder binder = null;
        switch (binderCode) {
        case CODE_BINDER_COMPUTE:
            binder = new IComputeImpl();

            break;
        case CODE_BINDER_PRINT:
            binder = new IPrintImpl();

            break;

        default:
            break;
        }
        return binder;
    }

}
