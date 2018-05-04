package com.terrydr.platform.config.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.config.database
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 2018/4/16 15:16
 * @version: 1.00
 */
@Configuration
public class TransactionConfig {

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource platformDataSource){
        return new DataSourceTransactionManager(platformDataSource);
    }
}
