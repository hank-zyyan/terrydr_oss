package com.terrydr.platform.config.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.config.database
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 2018/4/16 14:38
 * @version: 1.00
 */
@Configuration
@MapperScan(basePackages = {"com.terrydr.platform.dao"}, sqlSessionFactoryRef = "platformSessionFactory")
public class PlatformSqlSessionFactoryConfig {

    @Bean
    public SqlSessionFactory platformSessionFactory(DataSource platformDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(platformDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/platform/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate platformSessionTemplate(SqlSessionFactory platformSessionFactory) throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(platformSessionFactory);
        return template;
    }

}
