package com.bawei.songjiahao.songjihao.model;

import com.bawei.songjiahao.songjihao.api.ApiService;
import com.bawei.songjiahao.songjihao.contract.INewsContract;
import com.bawei.songjiahao.songjihao.entity.ShopEntity;
import com.bawei.songjiahao.songjihao.utils.RetorfitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间：2020/1/7 0007
 * 作者：Songjiahao
 * 类的作用：
 */
public class Model implements INewsContract.IModel {
    @Override
    public void getShop(ModelCallBack modelCallBack) {
        RetorfitUtils.getInstance().getClass(ApiService.class)
                .getMessage("13391","157844413914213391")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShopEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShopEntity shopEntity) {
                        modelCallBack.success(shopEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        modelCallBack.failure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
