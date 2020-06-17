package com.example.mvvmtest.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmtest.ViewModel.BuyViewModel;
import com.example.mvvmtest.databinding.ActivityMainBinding;
import com.example.mvvmtest.databinding.ItemBuyBinding;
import com.example.mvvmtest.entity.Buy;
import com.example.mvvmtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengmin
 * @description:
 * @date : 2020/6/17 11:29
 */
public class BuyAdpter extends RecyclerView.Adapter<BuyAdpter.ViewHolder> {

    public List<Buy> buyList;
    public Context mContext;
    public BuyAdpter(Context context) {
        this.buyList = new ArrayList<>();
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBuyBinding item = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.item_buy,parent,false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BuyViewModel buyViewModel = new BuyViewModel(buyList.get(position));
        holder.itembinding.setBuyBean(buyViewModel);
    }

    public void addItem(Buy buy) {
        buyList.add(buy);
        notifyItemInserted(buyList.size() - 1);
    }

    @Override
    public int getItemCount() {
        return buyList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        private ItemBuyBinding itembinding;
        public ViewHolder(@NonNull ItemBuyBinding itembinding) {
            super(itembinding.layout);

            this.itembinding = itembinding;
        }


    }
}
