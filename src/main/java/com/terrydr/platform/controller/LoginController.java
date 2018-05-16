package com.terrydr.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.controller
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 2018/4/17 11:19
 * @version: 1.00
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String defaultPath(){
        return "redirect:verifyCode";
    }

    @RequestMapping("/login")
    public String login(String username, String password, String verifyCode){
        return null;
    }

    @RequestMapping("/verifyCode")
    @ResponseBody
    public String verifyCode(){
        return "123456";
    }

}
