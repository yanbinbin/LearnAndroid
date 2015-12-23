/**
 * Project Name:TestBinderAsServer
 * File Name:IPrintImpl.java
 * Package Name:com.example.test.binder
 * Date:2015-12-23
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.binder;

import android.os.RemoteException;
import android.util.Log;

/**
 * ClassName: IPrintImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-12-23
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class IPrintImpl extends IPrint.Stub{

    /* (non-Javadoc)
     * @see com.example.test.binder.IPrint#print(java.lang.String)
     */
    @Override
    public void print(String info) throws RemoteException {
        // TODO Auto-generated method stub
        Log.d("test", "print()--->" + info);
    }

}
