package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/registerindex")
    public String registerIndex(){
        return "/user/register";
    }

    @RequestMapping("register")
    @ResponseBody
    public String register(String userName,String password,int age){
         System.out.println("register()中，userName="+userName+":password="+password+";age="+age);
         User user = new User();
         user.setUserName(userName);
         user.setPassword(password);
         user.setAge(age);

         userService.registerUser(user);

         return "success";
    }
}
