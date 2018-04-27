package com.example.a123.gankdemo.impl.imp;

import android.view.View;

import com.example.a123.gankdemo.impl.IBasePresenter;

/**
 * Created by 123 on 2018/4/27.
 */

public class BasePresenterImpl<T> implements IBasePresenter {

    private T view;

    protected void attachView(T view){
        this.view = view;
    }

    @Override
    public void detachView() {

    }
}
