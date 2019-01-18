package com.example.Interceptor;

import com.example.util.CookieUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object var3) throws Exception{
        System.out.println("preHandle开始");
        System.out.println("preHandle()中,"+request.getRequestURI()+"---被拦截---");
        String uid = CookieUtil.getCookie(request,"uid");
        System.out.println("preHandle()中,uid="+uid);
        if(uid == null){
            System.out.println("preHandle()中,跳转到注册页面！");
            //request.getRequestDispatcher("/user/registerindex").forward(request, response);
            response.sendRedirect("/user/registerindex");
            return false;
        }else{
            return true;
        }
    }

    public void postHandle(HttpServletRequest var1, HttpServletResponse var2, Object var3, ModelAndView var4) throws Exception{
        System.out.println("postHandle（）方法执行");
    }

    public void afterCompletion(HttpServletRequest var1, HttpServletResponse var2, Object var3, Exception var4) throws Exception{
        System.out.println("afterCompletion()执行");

    }
}
