package com.example.service.impl;

import com.example.dao.GoodsMapper;
import com.example.model.Goods;
import com.example.service.GoodsLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsLockServiceImpl implements GoodsLockService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Transactional(rollbackFor = Exception.class)
    public void buyGoods(int goodsId){
        System.out.println("buyGoods()中,goodsId="+goodsId);
        Goods goods = goodsMapper.getGoodsById(goodsId);
        if(goods == null){
            System.out.println("buyGoods()中,根据goodsId="+goodsId+"得到的商品为空");
        }else{
           int tempStock = goods.getStock();
           if(tempStock <= 0)
               System.out.println("buyGoods()中,商品goodsId="+goodsId+"已卖完");
           else{
               goodsMapper.updateGoods(goodsId);
               System.out.println("buyGoods()中,商品goodsId="+goodsId+"成功卖了一个");
           }
        }
    }
}
