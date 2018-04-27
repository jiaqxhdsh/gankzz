package com.example.a123.gankdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.example.a123.gankdemo.R;
import com.example.a123.gankdemo.bean.mob.GankEntity;
import com.example.a123.gankdemo.iView.IWelFareView;
import com.example.a123.gankdemo.impl.imp.WelFarePresenterImpl;
import com.example.a123.gankdemo.ui.base.BaseFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 123 on 2018/4/27.
 */

public class WelFareFragment extends BaseFragment implements IWelFareView, OnRefreshListener, OnLoadMoreListener {

    private WelFarePresenterImpl welFarePresenter;
    @Bind(R.id.swipe_target)
    RecyclerView swipeTarget;
    @Bind(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wel_fare,container,false);
        ButterKnife.bind(this, view);
        initRefresh();
        return view;
    }

    private void initRefresh() {
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        swipeTarget.setLayoutManager(staggeredGridLayoutManager);
        swipeTarget.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        welFarePresenter = new WelFarePresenterImpl(getActivity(), this);

    }

    public static WelFareFragment newInstance(){
        return new WelFareFragment();
    }

    @Override
    public void setWelFareList(List<GankEntity> welFareList) {

    }

    @Override
    public void setRandomList(List<GankEntity> randomList) {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void overRefresh() {

    }

    @Override
    public void setLoadMoreEnabled(boolean flag) {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
