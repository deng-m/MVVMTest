package com.example.mvvmtest.ViewModel;

import android.util.Log;

import com.example.mvvmtest.Net.RetrofitUtils;
import com.example.mvvmtest.adpter.BuyAdpter;
import com.example.mvvmtest.entity.Buy;

import rx.Subscriber;


/**
 * Created by HaohaoChang on 2017/2/11.
 */
public class MainViewModel {
    private Subscriber<Buy> subscriber;
    private BuyAdpter buyAdpter;

    public MainViewModel(BuyAdpter buyAdpter) {
        this.buyAdpter = buyAdpter;
        getMovies();
    }

    private void getMovies() {
        subscriber = new Subscriber<Buy>() {
            @Override
            public void onCompleted() {
                Log.d("[MainViewModel]", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Buy movie) {
                buyAdpter.addItem(movie);
            }
        };
        RetrofitUtils.getInstance().getBuyList(subscriber);
    }

    public void refreshData() {
        getMovies();
    }


}
