package com.example.dao;

import com.example.model.Goods;

public interface GoodsMapper {

    Goods getGoodsById(int id);

    void updateGoods(int id);
}
