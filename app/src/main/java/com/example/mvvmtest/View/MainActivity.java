package com.example.mvvmtest.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.mvvmtest.R;
import com.example.mvvmtest.ViewModel.MainViewModel;
import com.example.mvvmtest.adpter.BuyAdpter;
import com.example.mvvmtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding mainBinding;
BuyAdpter buyAdpter;
MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
         initData();

    }

    private void initData() {
        buyAdpter = new BuyAdpter(this);
        mainBinding.buyRv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        mainBinding.buyRv.setItemAnimator(new DefaultItemAnimator());
        mainBinding.buyRv.setAdapter(buyAdpter);
        mainViewModel = new MainViewModel(buyAdpter);
        mainBinding.setBuy(mainViewModel);

    }
}
