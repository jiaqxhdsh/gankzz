package com.example.a123.gankdemo.utils;



import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 123 on 2018/4/23.
 */

public class RxHelper {

    private RxHelper(){
        throw  new AssertionError();
    }

    /**
     * 倒计时
     * @param timer
     * @return
     */
    public static Observable<Integer> countdown(int timer){
        if(timer < 0){
            timer = 0;
        }
        final int countimer = timer;
        return Observable.interval(0,1, TimeUnit.SECONDS)
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(Long aLong) throws Exception {
                        return countimer - aLong.intValue();
                    }
                })
                .take(countimer + 1)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());

    }

}
