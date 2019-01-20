package com.example.thread;

import com.example.model.GapLock;
import com.example.service.GapLockService;

public class GasLockThread implements  Runnable {

    private GapLock gapLock;
    private GapLockService gapLockService;

    public GasLockThread(GapLock gapLock,GapLockService gapLockService){
        this.gapLock = gapLock;
        this.gapLockService = gapLockService;
    }

    @Override
    public void run(){
        gapLockService.insertPhone(gapLock);
    }
}
