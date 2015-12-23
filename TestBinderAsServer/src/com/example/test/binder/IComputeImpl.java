/**
 * Project Name:TestBinderAsServer
 * File Name:IComputeImpl.java
 * Package Name:com.example.test.binder
 * Date:2015-12-23
 * Copyright (c) 2015, www.meitu.com All Rights Reserved.
 *
 */

package com.example.test.binder;

import android.os.RemoteException;

/**
 * ClassName: IComputeImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Date:2015-12-23
 *
 * @author meitu.yanbb
 * @version 0.1
 * @since  MT 1.0
 *
 */
public class IComputeImpl extends ICompute.Stub{

    /* (non-Javadoc)
     * @see com.example.test.binder.ICompute#add(int, int)
     */
    @Override
    public int add(int a, int b) throws RemoteException {
        // TODO Auto-generated method stub
        return (a + b);
    }

}
