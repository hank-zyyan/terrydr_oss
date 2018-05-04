package com.terrydr.platform.config.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.config
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 2018/4/16 14:12
 * @version: 1.00
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.platform")
    public DataSource platformDataSource(){
        return DataSourceBuilder.create().build();
    }

}
