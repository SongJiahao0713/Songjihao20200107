package com.bawei.songjiahao.songjihao;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.songjiahao.songjihao.contract.INewsContract;
import com.bawei.songjiahao.songjihao.entity.ShopEntity;
import com.bawei.songjiahao.songjihao.presenter.Presenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements INewsContract.IView {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rv.setLayoutManager(new GridLayoutManager(this,2));
        Presenter presenter = new Presenter(this);
        presenter.getShop();
    }

    @Override
    public void success(ShopEntity shopEntity) {
        List<ShopEntity.ResultBean.ShoppingCartListBean> shoppingCartList = shopEntity.getResult().get(0).getShoppingCartList();
        MyAdapter myAdapter = new MyAdapter(this, shoppingCartList);
        rv.setAdapter(myAdapter);
    }

    @Override
    public void failure(Throwable throwable) {

    }
}
