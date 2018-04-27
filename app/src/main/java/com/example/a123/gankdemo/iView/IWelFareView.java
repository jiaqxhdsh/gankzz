package com.example.a123.gankdemo.iView;


import com.example.a123.gankdemo.bean.mob.GankEntity;

import java.util.List;

/**
 */
public interface IWelFareView {

    void setWelFareList(List<GankEntity> welFareList);

    void setRandomList(List<GankEntity> randomList);

    void showToast(String msg);

    void overRefresh();

    void setLoadMoreEnabled(boolean flag);

}
