package com.example.a123.gankdemo.impl.imp;

import android.view.View;

/**
 * Created by 123 on 2018/4/27.
 */

interface IWelFarePresenter {

    void getNewDatas();

    void getMoreDatas();

    void getRandomDatas();

    void itemClick(View view, int position);
}
