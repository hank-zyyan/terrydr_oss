package com.terrydr.common.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.config.mvc
 * @Description: 配置spring mvc，如拦截器，过滤器，监听，转换器，视图解析器等
 * @author: YanZhengYuan
 * @Date: 6/14/2018 5:07 PM
 * @version: 1.00
 */

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    /**
    * @Description: 允许跨域
    * @param registry
    * @author YanZhengYaun
    * @date 6/14/2018 7:23 PM
    */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
                .allowCredentials(false).maxAge(3600);
    }
}
