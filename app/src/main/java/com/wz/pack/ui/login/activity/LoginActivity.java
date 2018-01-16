package com.wz.pack.ui.login.activity;

import android.os.Bundle;
import android.util.Log;

import com.wz.pack.R;
import com.wz.baselib.mvpbase.BasePresenter;
import com.wz.baselib.mvpbase.baseImpl.BaseActivity;
import com.wz.pack.ui.login.contract.UserContract;
import com.wz.pack.ui.login.model.UserModel;
import com.wz.pack.ui.login.presenter.UserPresenter;

/**
 - @Author:  wang_zhen1
 - @Time:  2018/1/11 0011 14:51
 - @Description:  登录
 */

public class LoginActivity extends BaseActivity<UserContract.UserPresenter> implements UserContract.UserView {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        presenter.getData("wz","wz");
    }

    private void init() {
    }

    @Override
    public UserContract.UserPresenter initPresenter() {
        return new UserPresenter(this);
    }


    @Override
    public void setData(UserModel userModel) {
        Log.e("wz",userModel.toString()+"");
    }
}
