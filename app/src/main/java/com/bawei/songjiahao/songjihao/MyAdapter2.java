package com.bawei.songjiahao.songjihao;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.songjiahao.songjihao.entity.CarEntity;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 时间：2020/1/8 0008
 * 作者：Songjiahao
 * 类的作用：
 */
class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {
    private final Context context;
    private final List<CarEntity> list;

    public MyAdapter2(Context context, List<CarEntity> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item, null);
        MyAdapter2.MyViewHolder myViewHolder = new MyAdapter2.MyViewHolder(inflate);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getIv())
                .circleCrop()
                .into(holder.iv);
        holder.tv.setText(list.get(position).getTv());

    }

    @Override
    public int getItemCount() {
        return list.size();
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
}
