package com.terrydr.platform.controller;

import com.terrydr.common.utils.UserContext;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.controller
 * @Description: 验证码controller
 * @author: YanZhengYuan
 * @Date: 2018/4/17 11:19
 * @version: 1.00
 */
@Controller
@RequestMapping("verifyCode")
public class VerifyCodeController {

    @Resource
    private EhCacheCacheManager cacheManager;

    @RequestMapping("")
    @ResponseBody
    public String get(){
        return UserContext.getAccessToken();
    }

}
