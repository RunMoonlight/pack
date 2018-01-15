package com.wz.pack.ui.main.contact;

import com.wz.baselib.mvpbase.BasePresenter;
import com.wz.baselib.mvpbase.BaseView;
import com.wz.pack.ui.main.bean.MainBean;

/**
 - @Author:  wang_zhen1
 - @Time:  2018/1/15 0015 14:27
 - @Description:
 */

public interface MainContact {

    interface MainView extends BaseView{
        /**
         * 设置数据
         *
         * @param dataList
         */
        void setData(MainBean dataList);
    }
    interface presenter extends BasePresenter {
        /**
         * 获取数据
         */
        void getData();
    }
}
