package com.example.a123.gankdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by 123 on 2018/4/23.
 */

public class NetUtils {

    private static ConnectivityManager mConnectivityManager = null;

    private static ConnectivityManager getConnectivityManager(Context context) {
        if (mConnectivityManager == null) {
            mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
        }
        return mConnectivityManager;
    }

    /**
     * 判断是否具有网络连接
     *
     * @return
     */
    public static final boolean hasNetWorkConection(Context ctx) {
        // 获取连接活动管理器
        NetworkInfo activeNetworkInfo = getConnectivityManager(ctx).getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isAvailable());
    }

}
