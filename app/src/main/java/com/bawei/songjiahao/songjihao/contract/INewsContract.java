package com.bawei.songjiahao.songjihao.contract;

import android.view.View;

import com.bawei.songjiahao.songjihao.entity.ShopEntity;

/**
 * 时间：2020/1/7 0007
 * 作者：Songjiahao
 * 类的作用：
 */
public interface INewsContract {
    interface IModel{
        interface ModelCallBack{
            void success(ShopEntity shopEntity);
            void failure(Throwable throwable);
        }
        void getShop(ModelCallBack modelCallBack);
    }
    interface IView{
        void success(ShopEntity shopEntity);
        void failure(Throwable throwable);
    }
    interface IPresenter{
        void getShop();
    }
}
