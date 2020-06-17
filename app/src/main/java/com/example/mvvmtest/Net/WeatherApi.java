package com.example.mvvmtest.Net;

import retrofit2.http.GET;
import rx.Single;

/**
 * @author dengmin
 * @description:
 * @date : 2020/6/17 9:58
 */
    public interface WeatherApi {
    @GET("101210101.html")
    Single<Weather> getWeather();
}
