package com.bawei.songjiahao.songjihao.entity;

/**
 * 时间：2020/1/8 0008
 * 作者：Songjiahao
 * 类的作用：
 */
public class CarEntity {
    String iv;
    String tv;

    public CarEntity(String iv, String tv) {
        this.iv = iv;
        this.tv = tv;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }
}
