package com.wz.pack.api;

import com.wz.pack.config.ApiConfig;
import com.zhon.baselib.retroft.BaseApiImpl;

/**
 * Created by wang_zhen1 on 2018/1/11 0011.
 */

public class Api extends BaseApiImpl {

    private static Api api = new Api(ApiConfig.BASE_URL);

    public Api(String baseUrl) {
        super(baseUrl);
    }

    public static RetrofitService getInstance() {
        return api.getRetrofit().create(RetrofitService.class);
    }
}
