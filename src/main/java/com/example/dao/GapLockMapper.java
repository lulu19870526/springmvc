package com.example.dao;

import com.example.model.GapLock;

public interface GapLockMapper {

    GapLock getGapLockByPhone(String phone);

    void insertGapLock(GapLock gapLock);
}
