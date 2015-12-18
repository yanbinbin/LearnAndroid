/**
 * Project Name:FindMeituPhone File Name:ExplicitIntentUtilsForL.java Package
 * Name:com.meitu.mobile.findmeitu.services Date:2015-8-19 Copyright (c) 2015,
 * www.meitu.com All Rights Reserved.
 */

package com.example.testbinder;

import java.util.List;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

/**
 * ClassName: ExplicitIntentUtilsForL <br/>
 * Function: 5.0以后隐式绑定改为显示. <br/>
 * Date:2015-8-19
 * 
 * @author meitu.yanbb
 * @version 0.1
 * @since MT 1.0
 */
public class ExplicitIntentUtilsForL {
    /**
     * getExplicitIntent: 将隐式intent转为显示intent<br/>
     * 
     * @author meitu.yanbb
     * @param context
     * @param implicitIntent
     * @return
     * @since MT 1.0
     */
    public static Intent getExplicitIntent(Context context,
            Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent,
                0);
        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }
        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);
        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);
        // Set the component to be explicit
        explicitIntent.setComponent(component);
        return explicitIntent;
    }
}
