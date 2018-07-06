package com.terrydr.eye.config.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.config.database
 * @Description: OSS 眼科 事务配置
 * @author: YanZhengYuan
 * @Date: 2018/4/16 15:16
 * @version: 1.00
 */
@Configuration("eyeTransactionConfig")
public class TransactionConfig {

    @Bean
    public PlatformTransactionManager eyeTransactionManager(DataSource eyeDataSource){
        return new DataSourceTransactionManager(eyeDataSource);
    }
}
