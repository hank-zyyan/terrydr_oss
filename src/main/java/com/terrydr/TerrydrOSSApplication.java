package com.terrydr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr
 * @Description: Spring Boot 程序入口
 * @author: YanZhengYaun
 * @Date: 2018/4/14 16:11
 * @version: 1.00
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
public class TerrydrOSSApplication {

    private static EhCacheCacheManager cacheManager;

    @Autowired
    public void setEhCacheCacheManager(EhCacheCacheManager cacheManager){
        TerrydrOSSApplication.cacheManager = cacheManager;
    }

    /**
    * @Description: 程序入口方法
    * @param args
    * @return
    * @throws
    * @author YanZhengYaun
    * @date 2018/4/14 16:32
    */
    public static void main(String[] args) {
        SpringApplication.run(TerrydrOSSApplication.class, args);
        cacheManager.getCache("verifyCode");
    }
}
