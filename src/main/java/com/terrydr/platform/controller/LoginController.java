package com.terrydr.platform.controller;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.concurrent.Callable;

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
@CacheConfig(cacheNames = "verifyCode")
@RequestMapping("/login")
public class LoginController {

    @Resource
    private EhCacheCacheManager cacheManager;

    @RequestMapping("/v")
    public String defaultPath(){
        return "redirect:verifyCode";
    }

    @RequestMapping("/login")
    public String login(String username, String password, String verifyCode){
        return null;
    }

    @RequestMapping("/getCacheValue")
    @ResponseBody
    public String verifyCode(){
        return cacheManager.getCache("verifyCode").get("123", String.class);
    }

    @RequestMapping("")
    @ResponseBody
    public Callable callable(){
        return new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                return "5 seconds later";
            }
        };
    }

}
