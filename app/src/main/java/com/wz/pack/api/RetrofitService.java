package com.wz.pack.api;



import com.wz.pack.bean.MainBean;
import com.wz.pack.ui.login.model.UserModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface RetrofitService {


    @Headers({"urlname:gank"})
    @GET("api/data/Android/10/1")
    Observable<MainBean> getGank();

    @Headers({"urlname:pack"})
    @GET("user/login")
    Observable<UserModel> getUser(@Query("username") String username,@Query("password") String password );
}