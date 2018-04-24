package com.example.a123.gankdemo.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.a123.gankdemo.MainActivity;
import com.example.a123.gankdemo.R;
import com.example.a123.gankdemo.app.MyApplication;
import com.example.a123.gankdemo.skin.SkinManager;
import com.example.a123.gankdemo.utils.RxHelper;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by 123 on 2018/4/23.
 */

public class SplashActivity extends RxAppCompatActivity implements LifecycleProvider<ActivityEvent> {

    @Bind(R.id.tv_app_version)
    TextView tv_app_version;
    @Bind(R.id.shade_bg)
    TextView shadeBg;
    private boolean mIsSkip = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        int currentSkinType = SkinManager.getCurrentSkinType(this);
        if (currentSkinType == SkinManager.THEME_NIGHT) {
            shadeBg.setVisibility(View.VISIBLE);
        }

        upDateView();
        tv_app_version.setText(String.valueOf("V " + MyApplication.getVersionName()));

    }

    private void upDateView(){
        RxHelper.countdown(5)
                .compose(this.<Integer>bindToLife())
                .subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Integer integer) {
                shadeBg.setText("跳过 " + integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                _doSkip();
            }
        });

    }

    private void _doSkip( ) {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                //执行一些其他操作
                //.............
                //执行完毕，触发回调，通知观察者
              e.onNext("subscribe");
              e.onComplete();
            }

        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            //观察者接收到通知,进行相关操作
            public void onNext(String aLong) {
                Log.e("gggg","我接收到数据了" + aLong + " ----- ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        if (!mIsSkip) {
            mIsSkip = true;
            finish();
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        }
    }

    public <T> LifecycleTransformer<T> bindToLife() {
        return this.<T>bindToLifecycle();
    }

    @OnClick(R.id.shade_bg)
    public void onClick(){
        _doSkip();
    }


}
