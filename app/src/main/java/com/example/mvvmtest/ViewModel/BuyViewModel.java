package com.example.mvvmtest.ViewModel;


import androidx.databinding.BaseObservable;

import com.example.mvvmtest.entity.Buy;


/**
 * Created by HaohaoChang on 2017/2/11.
 */
public class BuyViewModel extends BaseObservable {
    private Buy Buy;

    public BuyViewModel(Buy Buy) {
        this.Buy = Buy;
    }



    public String getFund() {
        return Buy.getFund();
    }

    public float getPercent() {
        return Buy.getPercent();
    }

    public String getRemark(){
        return Buy.getRemark();
    }





}
