package com.bawei.songjiahao.songjihao.api;

import android.se.omapi.Session;

import com.bawei.songjiahao.songjihao.entity.ShopEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * 时间：2020/1/7 0007
 * 作者：Songjiahao
 * 类的作用：
 */
public interface ApiService {
    @GET("order/verify/v1/findShoppingCart/")
    Observable<ShopEntity> getMessage(@Header ("userId")String  userId,@Header("sessionId")String sessionId);
}
