package com.example.a123.gankdemo.http;

import io.reactivex.plugins.RxJavaPlugins;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 123 on 2018/4/23.
 */

public class BuildApi {

    private static Retrofit retrofit;


    public static APIService getBuildApi(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())  //设置默认的解析库：Gson
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit.create(APIService.class);
    }




}
