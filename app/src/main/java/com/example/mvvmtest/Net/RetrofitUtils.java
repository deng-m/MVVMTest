package com.example.mvvmtest.Net;

/**
 * @author dengmin
 * @description:
 * @date : 2020/6/17 9:18
 */

import com.example.mvvmtest.entity.Buy;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Retrofit封装
 */
public class RetrofitUtils {
    private static final String TAG = "RetrofitUtils";
    private static final String BaseUrl = "https://api.douban.com/v2/Buy/";
    private static final long DEFAULT_TIME = 1000;
    private static ApiUrl mApiUrl;
    OkHttpClient.Builder client;


    private static class singleTon{
        private static final RetrofitUtils instance = new RetrofitUtils();

    }

    public static RetrofitUtils getInstance(){
        return  singleTon.instance;
    }

    /**
     * 单例模式
     */
    // 主要就是调用这个方法获得Retrofit的接口服务对象
    public static ApiUrl getApiUrl() {
        if (mApiUrl == null) {
            synchronized (RetrofitUtils.class) {
                if (mApiUrl == null) {
                    mApiUrl = new RetrofitUtils().getRetrofit();
                }
            }
        }
        return mApiUrl;
    }
    private RetrofitUtils(){}

    public  ApiUrl getRetrofit() {
        // 初始化Retrofit
        ApiUrl apiUrl = initRetrofit() .create(ApiUrl.class);
        return apiUrl;
    }

    /**
     * 初始化Retrofit
     */
    private Retrofit initRetrofit() {
        client = new OkHttpClient.Builder();
        client.connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS);
        return new Retrofit.Builder()
                .client(client.build())
                .baseUrl(BaseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public   void getBuyList(Subscriber<Buy> subscriber){
        getRetrofit().getBuyList()
                .map(new Func1<List<Buy>, List<Buy>>() {
                    @Override
                    public List<Buy> call(List<Buy> buys) {
                        return buys;
                    }
                })
                .flatMap(new Func1<List<Buy>, Observable<Buy>>() {
                    @Override
                    public Observable<Buy> call(List<Buy> buys) {
                        return Observable.from(buys);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
