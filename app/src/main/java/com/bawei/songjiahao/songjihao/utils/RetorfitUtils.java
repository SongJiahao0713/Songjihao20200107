package com.bawei.songjiahao.songjihao.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间：2020/1/7 0007
 * 作者：Songjiahao
 * 类的作用：
 */
public class RetorfitUtils {
    private static RetorfitUtils retorfitUtils;
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;

    private RetorfitUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://172.17.8.100/small/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static RetorfitUtils getInstance() {
        if (retorfitUtils==null){
            synchronized (RetorfitUtils.class){
                if (retorfitUtils==null){
                    retorfitUtils=new RetorfitUtils();
                }
            }
        }
        return retorfitUtils;
    }

    public <T>T getClass(Class<T> tClass){
        T t = retrofit.create(tClass);
        return t;
    }

}
