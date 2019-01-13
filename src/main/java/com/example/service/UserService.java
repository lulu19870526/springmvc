package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {

    int registerUser(User user);

    List<User> getAllUsers();
}
