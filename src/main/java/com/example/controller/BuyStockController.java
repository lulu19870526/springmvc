package com.example.controller;

import com.example.service.BuyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/stock")
public class BuyStockController {

    @Autowired
    private BuyStockService buyStockService;

    @RequestMapping("/hasexception")
    @ResponseBody
    public String buyStockHasException(){
        try {
            System.out.println("hello");
            buyStockService.buyStock("璐璐",900,"APPLE",100,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "beijing";
    }

    @RequestMapping("/buysuccess")
    @ResponseBody
    public String buyStockSuccess(){
        try {
            System.out.println("hello");
            buyStockService.buyStock("璐璐",900,"APPLE",100,false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "beijing";
    }
}
