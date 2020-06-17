package com.example.mvvmtest.Net;

import com.example.mvvmtest.entity.Buy;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author dengmin
 * @description:
 * @date : 2020/6/17 13:25
 */
public interface ApiUrl {
    @GET("buyList")
    Observable<List<Buy>> getBuyList();
}
