package com.example.a123.gankdemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a123.gankdemo.ui.fragment.WelFareFragment;

public class MainActivity extends AppCompatActivity {

    private WelFareFragment welFareFragment;
    private int navigationCheckedItemId = R.id.nav_fuli;
    private int menuSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDefaultFragment();

    }

    private void setDefaultFragment() {
        setMenuSelection(navigationCheckedItemId);
    }

    public void setMenuSelection(int menuSelection) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if(welFareFragment == null){
            welFareFragment = WelFareFragment.newInstance();
            fragmentTransaction.add(R.id.frame_content,welFareFragment);
        }else {
            fragmentTransaction.show(welFareFragment);
        }
        fragmentTransaction.commitNowAllowingStateLoss();
    }
}
