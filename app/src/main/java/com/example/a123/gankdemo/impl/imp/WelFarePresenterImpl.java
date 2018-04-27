package com.example.a123.gankdemo.impl.imp;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.a123.gankdemo.bean.mob.GankEntity;
import com.example.a123.gankdemo.constant.Constants;
import com.example.a123.gankdemo.http.GankApi;
import com.example.a123.gankdemo.iView.IWelFareView;
import com.example.a123.gankdemo.ui.fragment.WelFareFragment;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 123 on 2018/4/27.
 */

public class WelFarePresenterImpl extends BasePresenterImpl<IWelFareView> implements IWelFarePresenter{

    private Context context;
    private int pageSize = 20;
    private int pageIndex = 1;

    public WelFarePresenterImpl(Context activity, IWelFareView welFareFragment) {
        attachView(welFareFragment);
        context = activity;
    }

    @Override
    public void getNewDatas() {
        GankApi.getCommonDataNew(Constants.FlagWelFare, pageSize, 1).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<GankEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<GankEntity> gankEntities) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getMoreDatas() {

    }

    @Override
    public void getRandomDatas() {

    }

    @Override
    public void itemClick(View view, int position) {

    }
}
