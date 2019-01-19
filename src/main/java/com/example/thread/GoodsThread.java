package com.example.thread;

import com.example.service.GoodsLockService;

public class GoodsThread implements Runnable {

    private int goodId;

    private GoodsLockService goodsLockService;

    public GoodsThread(){

    }

    public GoodsThread(int goodId,GoodsLockService goodsLockService){
        this.goodId = goodId;
        this.goodsLockService = goodsLockService;
    }

    @Override
    public void run(){
        goodsLockService.buyGoods(goodId);
    }
}
