package com.example.service.impl;

import com.example.dao.GapLockMapper;
import com.example.model.GapLock;
import com.example.service.GapLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GapLockServiceImpl implements GapLockService {

    @Autowired
    private GapLockMapper gapLockMapper;

    @Transactional(rollbackFor = Exception.class)
    public void insertPhone(GapLock gapLock){
        for(int i =0;i<3;i++){
            try {
                System.out.println("insertPhone()中gapLock="+gapLock);
                GapLock dbGapLock = gapLockMapper.getGapLockByPhone(gapLock.getPhone());
                if(dbGapLock != null){
                    System.out.println("insertPhone()中,已经存在phone="+gapLock.getPhone());
                }else{
                    gapLockMapper.insertGapLock(gapLock);
                    System.out.println("insertPhone()中,成功insert一条phone="+gapLock.getPhone());
                }
                break;
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }

    }
}
