package com.bawei.songjiahao.songjihao;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.songjiahao.songjihao.entity.CarEntity;
import com.bawei.songjiahao.songjihao.entity.ShopEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {
    List<CarEntity> list = new ArrayList<>();
    @BindView(R.id.main2_rv)
    RecyclerView main2Rv;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        main2Rv.setLayoutManager(new LinearLayoutManager(this));
        myAdapter.setMyCallBack(new MyAdapter.MyCallBack() {
            @Override
            public void getlist(String iv, String tv) {
                CarEntity carEntity = new CarEntity(iv, tv);
                list.add(carEntity);
                MyAdapter2 myAdapter2 = new MyAdapter2(Main2Activity.this, list);
                main2Rv.setAdapter(myAdapter2);
            }
        });
        main2Rv.setAdapter(myAdapter);

    }
}
