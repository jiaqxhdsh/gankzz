package com.example.a123.gankdemo.http;

import com.example.a123.gankdemo.bean.HttpResult;
import com.example.a123.gankdemo.bean.mob.GankEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by 123 on 2018/4/27.
 * 所有的网络请求
 */

public class GankApi {


    public static Observable<List<GankEntity>> getCommonDataNew(String type, int count, int pageIndex){
       return BuildApi.getBuildApi().getCommonDateNew(type,count,pageIndex)
               .map(new Function<HttpResult<List<GankEntity>>, List<GankEntity>>() {
                   @Override
                   public List<GankEntity> apply(HttpResult<List<GankEntity>> listHttpResult) throws Exception {
                       return listHttpResult.getResults();
                   }
               });
    }


}
