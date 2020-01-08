package com.bawei.songjiahao.songjihao.presenter;

import com.bawei.songjiahao.songjihao.contract.INewsContract;
import com.bawei.songjiahao.songjihao.entity.ShopEntity;
import com.bawei.songjiahao.songjihao.model.Model;

/**
 * 时间：2020/1/7 0007
 * 作者：Songjiahao
 * 类的作用：
 */
public class Presenter implements INewsContract.IPresenter {
    INewsContract.IView iView;
    Model model;
    public Presenter(INewsContract.IView iView) {
        this.iView = iView;
        this.model=new Model();
    }

    @Override
    public void getShop() {
        model.getShop(new INewsContract.IModel.ModelCallBack() {
            @Override
            public void success(ShopEntity shopEntity) {
                iView.success(shopEntity);
            }

            @Override
            public void failure(Throwable throwable) {
                iView.failure(throwable);
            }
        });
    }
}
