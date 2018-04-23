package com.example.a123.gankdemo.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.support.multidex.MultiDex;
import android.support.v4.BuildConfig;

import com.example.a123.gankdemo.utils.ACache;
import com.maning.librarycrashmonitor.MCrashMonitor;
import com.readystatesoftware.chuck.ChuckInterceptor;
import com.socks.library.KLog;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;


/**
 * Created by 123 on 2018/4/19.
 */

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";
    private static MyApplication myApplication;
    private static Handler mHandler;
    private static ACache aCache;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initBase();

        initLog();

        initUmeng();

        initCrash();
    }

    private void initCrash() {
        /**
         * 初始化日志系统
         * context :    上下文
         * isDebug :    是不是Debug模式,true:崩溃后显示自定义崩溃页面 ;false:关闭应用,不跳转奔溃页面(默认)
         */
        MCrashMonitor.init(this, true);
    }

    private void initUmeng() {
        //禁止默认的页面统计方式
        MobclickAgent.openActivityDurationTrack(false);
        //获取渠道
        String channel = "saber";

        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:友盟 app key
         * 参数3:友盟 channel
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret
         */
        UMConfigure.init(this, "56dce179e0f55ac5d700046c", channel, UMConfigure.DEVICE_TYPE_PHONE, "");
        /**
         * 设置组件化的Log开关
         * 参数: boolean 默认为false，如需查看LOG设置为true
         */
        UMConfigure.setLogEnabled(true);
    }

    private void initLog() {
        KLog.init(true, "---GankMM---");
    }


    private void initJpush() {


    }

    private void initBase() {
        myApplication = this;
        aCache = ACache.get(this);

    }

    public static ACache getACathe(){
        return aCache;
    }

    public static MyApplication getMyApplication(){
        return myApplication;
    }

    public static Handler getHandle(){
        if(mHandler == null){
            mHandler = new Handler();
        }
        return mHandler;
    }

    public static OkHttpClient defaultOkHttpClient(){
        OkHttpClient.Builder client = new Builder();
        client.writeTimeout(30 * 1000, TimeUnit.MILLISECONDS);
        client.readTimeout(20 * 1000, TimeUnit.MILLISECONDS);
        client.connectTimeout(30 * 1000, TimeUnit.MILLISECONDS);
        //设置缓存路劲
        File httpCacheDir = new File(myApplication.getCacheDir(), "okhttpCache");
        //设置缓存 10m
        Cache cache = new Cache(httpCacheDir,10 * 1024 * 1024);
        client.cache(cache);
        //设置拦截器
        client.addInterceptor(new ChuckInterceptor(myApplication));

        return  client.build();
    }

}
