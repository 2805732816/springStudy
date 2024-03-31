package com.interfaces;


import com.alibaba.fastjson.JSONObject;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.*;

import java.util.Map;


public interface BaiDuService {


        /**
         * get请求实例
         * @param params
         * @param headerMap
         * @return
         */
        @GET("/search")
        @Headers({"Content-Type:application/json"})
        Call<ResponseBody> get(@QueryMap Map<String,String> params, @HeaderMap Map<String,String> headerMap);

        /**
         * post请求demo
         * @param params post请求的params
         * @param header post请求的header
         * @param jsonObject post请求的body
         * @return
         */
        @POST("/post")
        @Headers({"Content-Type:application/json"})
        Call<ResponseBody> post(@QueryMap Map<String,String> params,
                                @HeaderMap Map<String,String> header, @Body JSONObject jsonObject);


    }

