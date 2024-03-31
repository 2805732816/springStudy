package com.utils;

import retrofit2.Retrofit;

public class RetrofitUtils {
    private static Retrofit retrofit;
    //双重检查法获取实例对象
    public static <T> T getService(Class<T> serviceClass,String baseUrl){
        if(retrofit == null){
            synchronized (RetrofitUtils.class){
                if(retrofit == null){
                    retrofit = new Retrofit.Builder()
                            .baseUrl(baseUrl)
                            .build();
                }
            }
        }
        return retrofit.create(serviceClass);
    }
    //私有化构造方法
    private RetrofitUtils(){

    }
}

