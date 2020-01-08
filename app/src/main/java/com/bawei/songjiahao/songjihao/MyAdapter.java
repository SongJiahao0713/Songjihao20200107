package com.bawei.songjiahao.songjihao;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.songjiahao.songjihao.entity.CarEntity;
import com.bawei.songjiahao.songjihao.entity.ShopEntity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间：2020/1/7 0007
 * 作者：Songjiahao
 * 类的作用：
 */
class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final Context context;
    private final List<ShopEntity.ResultBean.ShoppingCartListBean> shoppingCartList;


    public MyAdapter(Context context, List<ShopEntity.ResultBean.ShoppingCartListBean> shoppingCartList) {
        this.context = context;
        this.shoppingCartList = shoppingCartList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context)
                .load(shoppingCartList.get(position).getPic())
                .circleCrop()
                .into(holder.iv);
        holder.tv.setText(shoppingCartList.get(position).getCommodityName());
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myCallBack.getlist(shoppingCartList.get(position).getPic(), shoppingCartList.get(position).getCommodityName());
            }
        });
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCallBack.getlist(shoppingCartList.get(position).getPic(), shoppingCartList.get(position).getCommodityName());

            }
        });
    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv)
        TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    MyCallBack myCallBack;

    public void setMyCallBack(MyCallBack myCallBack) {
        this.myCallBack = myCallBack;
    }

    public interface MyCallBack{
        void getlist(String iv,String tv);
    }
}
