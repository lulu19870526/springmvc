package com.example.service.impl;

import com.example.dao.AccountMapper;
import com.example.dao.StockMapper;
import com.example.service.BuyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuyStockServiceImpl implements BuyStockService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private StockMapper stockMapper;

    @Override
    @Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED,rollbackFor = Exception.class)
    //@Transactional(isolation= Isolation.DEFAULT, propagation= Propagation.REQUIRED)
    public void buyStock(String accountName,int newAccontBalance,String stockName
            ,int newStockBalance,boolean isHasExceptionFlag)throws Exception{
        System.out.println("buyStock()中,accountName="+accountName+";newAccontBalance="+
                newAccontBalance+";stockName="+stockName+";newStockBalance="+newStockBalance
                +";isHasExceptionFlag="+isHasExceptionFlag);

        accountMapper.updateAccount(accountName,newAccontBalance);

        if(isHasExceptionFlag)
            //throw new RuntimeException("账户更新成功后，出现异常");
           throw new Exception("账户更新成功后，出现异常");

        stockMapper.updateStock(stockName,newStockBalance);

    }
}
