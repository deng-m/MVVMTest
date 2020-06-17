package com.example.mvvmtest.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmtest.R;
import com.example.mvvmtest.entity.Buy;

import java.util.List;

/**
 * @author dengmin
 * @description:
 * @date : 2020/6/17 11:29
 */
public class NewsAdpter extends RecyclerView.Adapter {

    public List<Buy> buyList;
    public Context mContext;
    public NewsAdpter(List<Buy> buys, Context context) {
        this.buyList = buys;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_buy,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView fundTx,percentTx,remarkTx;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fundTx = itemView.findViewById(R.id.fundTx);
            percentTx = itemView.findViewById(R.id.percentTx);
            remarkTx = itemView.findViewById(R.id.remarkTx);
        }


    }
}
