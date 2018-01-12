package com.wz.pack.ui.login.activity;

import android.os.Bundle;

import com.wz.baselib.mvpbase.BasePresenter;
import com.wz.baselib.mvpbase.baseImpl.BaseActivity;
import com.wz.pack.R;

/**
 * Created by wang_zhen1 on 2018/1/12 0012.
 */

public class RegistActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        init();

    }

    private void init() {

    }



    @Override
    public BasePresenter initPresenter() {
        return null;
    }
}
