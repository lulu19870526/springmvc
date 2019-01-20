package com.example.controller;

import com.example.model.GapLock;
import com.example.service.GapLockService;
import com.example.thread.GasLockThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/gaslock")
public class GapLockController {

    @Autowired
    private GapLockService gapLockService;

    @RequestMapping("/register")
    @ResponseBody
    public String register(String phone,String pwd){
        GapLock gapLock = new GapLock();
        gapLock.setPhone(phone);
        gapLock.setPwd(pwd);

        for(int i =0;i<10;i++)
            new Thread(new GasLockThread(gapLock,gapLockService)).start();
        return "success";
    }
}
