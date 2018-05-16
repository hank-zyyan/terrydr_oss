package com.terrydr.common.config.shiro;

import com.terrydr.common.shiro.OSSRealm;
import com.terrydr.common.utils.Constant;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.config.shiro
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 2018/5/4 14:29
 * @version: 1.00
 */
@Configuration
public class ShiroConfig {

    @Value("${cacheType}")
    private String cacheType;

    /**
    * @Description: shiro security manager bean
    * @param
    * @return SecurityManager
    * @throws
    * @author YanZhengYaun
    * @date 2018/5/4 14:32
    */
    @Bean
    public SecurityManager securityManager(OSSRealm realm){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //设置realm.
        securityManager.setRealm(realm);
        // 自定义缓存实现 使用redis
        if(Constant.CACHE_TYPE_REDIS.equals(cacheType)){
            securityManager.setCacheManager(cacheManager());
        }else {// 使用ehcache
            securityManager.setCacheManager(ehCacheManager());
        }
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }
    
}
