package com.terrydr.eye.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.terrydr.eye.properties.EyeDataSourceProperties;
import com.terrydr.platform.properties.PlatformDataSourceProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.config
 * @Description: 数据库配置类
 * @author: YanZhengYuan
 * @Date: 2018/4/16 14:12
 * @version: 1.00
 */
@Configuration("eyeDataSourceConfig")
public class DataSourceConfig {

    private static final Log logger = LogFactory.getLog(DataSourceConfig.class);

    @Resource
    private EyeDataSourceProperties eyeDataSourceProperties;

    @Bean
    public DataSource eyeDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(eyeDataSourceProperties.getUrl());
        dataSource.setUsername(eyeDataSourceProperties.getUsername());
        dataSource.setPassword(eyeDataSourceProperties.getPassword());
        dataSource.setDriverClassName(eyeDataSourceProperties.getDriver());
        dataSource.setInitialSize(eyeDataSourceProperties.getInitialSize());
        dataSource.setMaxActive(eyeDataSourceProperties.getMaxActive());
        dataSource.setMinIdle(eyeDataSourceProperties.getMinIdle());
        dataSource.setMaxWait(eyeDataSourceProperties.getMaxWait());
        dataSource.setValidationQuery(eyeDataSourceProperties.getValidationQuery());
        dataSource.setTestOnBorrow(eyeDataSourceProperties.isTestOnBorrow());
        dataSource.setTestWhileIdle(eyeDataSourceProperties.isTestWhileIdle());
        try {
            dataSource.setFilters(eyeDataSourceProperties.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("眼科数据源注入失败");
        }
        return dataSource;
    }

}
