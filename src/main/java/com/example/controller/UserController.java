package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/registerindex")
    public String registerIndex(){
        return "/user/register";
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(String userName,String password,int age){
        try {
            System.out.println("register()中，userName="+userName+":password="+password+";age="+age);
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setAge(age);

            int userId = userService.registerUser(user);
            System.out.println("register()中，userId="+userId+";userName="+userName+":password="+password+";age="+age);
            return userId+"";
        } catch (Exception e) {
            System.out.println("register()中出现异常，userName="+userName+":password="+password+";age="+age);
        }
        return "fail";
    }

    @RequestMapping("/registersuccess")
    public ModelAndView registerSuccess(int id,String userName,String password,int age){
        System.out.println("registerSuccess()中,id="+id+";userName="+userName+":password="+password+";age="+age);

        //ModelAndView modelAndView = new ModelAndView("/user/registerSuccess");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/registerSuccess");

        //modelAndView.getModel().put("id",id);
        modelAndView.addObject("id",id);
        modelAndView.getModel().put("userName",userName);
        modelAndView.getModel().put("password",password);
        modelAndView.getModel().put("age",age);
        return modelAndView;
    }

    @RequestMapping("/registersuccess1")
    public String registerSuccess1(int id, String userName, String password, int age, ModelMap model){
        System.out.println("registerSuccess1()中,id="+id+";userName="+userName+":password="+password+";age="+age);
        model.addAttribute("id",id);
        model.addAttribute("userName",userName);
        model.addAttribute("password",password);
        model.addAttribute("age",age);

        return "/user/registerSuccess";
    }
}
