package com.keymao.sso.controller;

import com.keymao.common.utils.CookieUtils;
import com.keymao.common.utils.E3Result;
import com.keymaoshop.sso.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/page/login")
    public  String showLogin(){
        return "login";
    }

    @Value("${TOKEN_KEY}")
    private String TOKEN_KEY;

    @RequestMapping(value="/user/login", method=RequestMethod.POST)
    @ResponseBody
    public E3Result login(String username, String password,HttpServletRequest request, HttpServletResponse response) {
        E3Result e3Result = loginService.userLogin(username, password);
        //判断是否登录成功
        if(e3Result.getStatus() == 200) {
            String token = e3Result.getData().toString();
            //如果登录成功需要把token写入cookie
            CookieUtils.setCookie(request, response, TOKEN_KEY, token);
        }
        //返回结果
        return e3Result;

    }

    @RequestMapping(value="/user/logout")
    public String logout(String token) {
        //E3Result e3Result = new E3Result(token);
        //System.out.println(token);
        //返回结果
        if (!StringUtils.isBlank(token)) {
            loginService.userLogout(token);
        }
        //删除Redis对应的数据
        return "login";

    }

}
