package com.example.controller;

import com.example.service.GoodsLockService;
import com.example.thread.GoodsThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/goods")
public class GoodsLockController {

    @Autowired
    private GoodsLockService goodsLockService;

    @RequestMapping("/buy")
    @ResponseBody
    public String buyGoods(int goodsId){
        System.out.println("buyGoods()中,goodsId="+goodsId);
        goodsLockService.buyGoods(goodsId);
        return "success";
    }

    @RequestMapping("/buymultithread")
    @ResponseBody
    public String buyGoodsMultiThread(int goodsId){
        System.out.println("buyGoodsMultiThread()中,goodsId="+goodsId);
        for(int i= 0;i<20;i++)
            new Thread(new GoodsThread(goodsId,goodsLockService)).start();
        return "success";
    }
}
