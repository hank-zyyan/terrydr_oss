package com.terrydr.platform.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import com.terrydr.common.utils.OSSContext;
import com.terrydr.platform.properties.PlatformDataSourceProperties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
@Configuration
public class DataSourceConfig {

    private static final Log logger = LogFactory.getLog(DataSourceConfig.class);

    @Resource
    private PlatformDataSourceProperties platformDataSourceProperties;

    @Bean
    public DataSource platformDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(platformDataSourceProperties.getUrl());
        dataSource.setUsername(platformDataSourceProperties.getUsername());
        dataSource.setPassword(platformDataSourceProperties.getPassword());
        dataSource.setDriverClassName(platformDataSourceProperties.getDriver());
        dataSource.setInitialSize(platformDataSourceProperties.getInitialSize());
        dataSource.setMaxActive(platformDataSourceProperties.getMaxActive());
        dataSource.setMinIdle(platformDataSourceProperties.getMinIdle());
        dataSource.setMaxWait(platformDataSourceProperties.getMaxWait());
        dataSource.setValidationQuery(platformDataSourceProperties.getValidationQuery());
        dataSource.setTestOnBorrow(platformDataSourceProperties.isTestOnBorrow());
        dataSource.setTestWhileIdle(platformDataSourceProperties.isTestWhileIdle());
        try {
            dataSource.setFilters(platformDataSourceProperties.getFilters());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("平台数据源注入失败");
        }
        return dataSource;
    }

}
