package com.keymao.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegitsterController {

    @RequestMapping("/page/regitster")
    public  String showRegitster(){
        return "register";
    }
}
