package com.terrydr.common.config.shiro;

import com.terrydr.common.shiro.OSSVerifyCodeRealm;
import com.terrydr.common.shiro.OSSSessionManager;
import com.terrydr.common.utils.Constant;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

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

    @Bean
    ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/docs/**", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/upload/**", "anon");
        filterChainDefinitionMap.put("/files/**", "anon");
        filterChainDefinitionMap.put("/verifyCode/get", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
    * @Description: shiro security manager bean
    * @param
    * @return SecurityManager
    * @throws
    * @author YanZhengYaun
    * @date 2018/5/4 14:32
    */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //设置realm.
        securityManager.setRealm(ossRealm());
        // 自定义缓存实现 使用redis
        if(Constant.CACHE_TYPE_REDIS.equals(cacheType)){
            securityManager.setCacheManager(shiroEhCacheManager());
        }else {// 使用ehcache
            securityManager.setCacheManager(shiroEhCacheManager());
        }
        securityManager.setSessionManager(ossSessionManager());
        return securityManager;
    }

    @Bean
    public SessionManager ossSessionManager(){
        SessionManager ossSessionManager = new OSSSessionManager();

        return ossSessionManager;
    }

    @Bean
    public Realm ossRealm(){
        Realm realm = new OSSVerifyCodeRealm();
        return realm;
    }

    @Bean
    public EhCacheManager shiroEhCacheManager(){
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:config/cache/ehcache.xml");
        return em;
    }

    /**
     *  开启shiro aop注解支持.
     *  使用代理方式;所以需要开启代码支持;
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
