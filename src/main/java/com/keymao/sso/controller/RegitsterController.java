package com.keymao.sso.controller;

import com.keymao.common.utils.E3Result;
import com.keymaoshop.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegitsterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/page/regitster")
    public  String showRegitster(){
        return "register";
    }

    @RequestMapping("/user/check/{param}/{type}")
    @ResponseBody
    public E3Result checkData(@PathVariable String param,@PathVariable Integer type){
        E3Result e3Result = registerService.checkData(param, type);
        return  e3Result;
    }
}
