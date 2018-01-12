package com.wz.pack.ui.login.activity;

import android.os.Bundle;

import com.wz.pack.R;
import com.wz.baselib.mvpbase.BasePresenter;
import com.wz.baselib.mvpbase.baseImpl.BaseActivity;

/**
 - @Author:  wang_zhen1
 - @Time:  2018/1/11 0011 14:51
 - @Description:  登录
 */

public class LoginActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

    }



    private void init() {

    }

    @Override
    public BasePresenter initPresenter() {
        return null;

    }


}
