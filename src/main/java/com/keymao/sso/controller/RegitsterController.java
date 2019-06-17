package com.keymao.sso.controller;

import com.keymao.common.utils.E3Result;
import com.keymao.pojo.TbUser;
import com.keymaoshop.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegitsterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/page/register")
    public  String showRegitster(){
        return "register";
    }

    @RequestMapping("/user/check/{param}/{type}")
    @ResponseBody
    public E3Result checkData(@PathVariable String param,@PathVariable Integer type){
        E3Result e3Result = registerService.checkData(param, type);
        return  e3Result;
    }

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    @ResponseBody
    public E3Result register(TbUser tbUser){
        E3Result e3Result = registerService.register(tbUser);
        return  e3Result;
    }
}
