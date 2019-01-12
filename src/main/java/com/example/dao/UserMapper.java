package com.example.dao;

import com.example.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    //根据用户名和密码查找。mybatis中有多个参数时，需要使用@Param注解
    User findByUserNameAndPassword(@Param("username")String username, @Param("password")String password);

    //增加用户
    int addUser(User user);

    //根据用户名查询
    User findByUserName(String username);
}
