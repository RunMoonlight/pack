package com.wz.pack.api;



import com.wz.pack.bean.TestBean;
import com.wz.pack.ui.main.bean.MainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface RetrofitService {

    /**
     * 测试接口
     *
     * @return
     */
    @GET("news/latest")
    Observable<TestBean> test();

    @GET("data/Android/10/1")
    Observable<MainBean> getGank();

}