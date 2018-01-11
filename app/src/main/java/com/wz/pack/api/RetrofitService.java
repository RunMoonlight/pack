package com.wz.pack.api;



import com.wz.pack.bean.TestBean;

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


}