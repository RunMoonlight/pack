package com.wz.pack.ui.login.contract;

import com.wz.baselib.mvpbase.BasePresenter;
import com.wz.baselib.mvpbase.BaseView;
import com.wz.pack.ui.login.model.UserModel;

/**
 * Created by wang_zhen1 on 2018/1/16 0016.
 */

public interface UserContract {
    interface UserView extends BaseView {

        void setData(UserModel userModel);
    }
    interface UserPresenter extends BasePresenter {
        /**
         * 获取数据
         */
        void getData(String name,String pwd);
    }
}
