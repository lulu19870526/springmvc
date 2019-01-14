package com.example.service;

public interface BuyStockService {

    void buyStock(String accountName,int newAccontBalance,String stockName,int newStockBalance,boolean isHasExceptionFlag)throws Exception;
}
