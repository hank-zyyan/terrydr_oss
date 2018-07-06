package com.terrydr.eye.config.database;

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
 * @Description: OSS 眼科 session config
 * @author: YanZhengYuan
 * @Date: 2018/4/16 14:38
 * @version: 1.00
 */
@Configuration
@MapperScan(basePackages = {"com.terrydr.eye.dao"}, sqlSessionFactoryRef = "eyeSessionFactory")
public class EyeSqlSessionFactoryConfig {

    @Bean
    public SqlSessionFactory eyeSessionFactory(DataSource eyeDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(eyeDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mybatis/eye/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate eyeSessionTemplate(SqlSessionFactory eyeSessionFactory) throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(eyeSessionFactory);
        return template;
    }

}
