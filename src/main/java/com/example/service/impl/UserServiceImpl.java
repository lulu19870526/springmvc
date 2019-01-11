package com.example.service.impl;

import com.example.dao.UserMapper;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //注入UserMapper接口
   @Autowired
    private UserMapper userMapper;

   @Override
    public void registerUser(User user){
        userMapper.addUser(user);
    }
}
