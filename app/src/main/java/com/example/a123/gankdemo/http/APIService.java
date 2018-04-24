package com.example.a123.gankdemo.http;



import com.example.a123.gankdemo.bean.HttpResult;
import com.example.a123.gankdemo.constant.Constants;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by 123 on 2018/4/23.
 */

public interface APIService {

    //这里填写全部路径就会覆盖掉Build得BaseUrl
    @Headers("Cache-Control: public, max-age=3600")
    @GET(Constants.URL_HistoryDate)
    Observable<HttpResult<List<String>>> getGankHistoryDate();

}
