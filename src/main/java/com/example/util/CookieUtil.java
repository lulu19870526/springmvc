package com.example.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    public static void writeCookie(HttpServletResponse response, String key, String value, String path, int second){
        Cookie namecookie = new Cookie(key, value);
        namecookie.setMaxAge(second);
        namecookie.setPath(path);
        namecookie.setDomain("/");
        response.addCookie(namecookie);
    }

    public static String getCookie(HttpServletRequest request, String key){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(key)) {
                    return cookies[i].getValue();
                }

            }
        }
        return null;
    }
}
