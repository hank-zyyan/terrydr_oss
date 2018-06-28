package com.terrydr.common.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.filter
 * @Description: Access Log
 * @author: YanZhengYuan
 * @Date: 6/14/2018 7:41 PM
 * @version: 1.00
 */

@WebFilter
@Component
@ConditionalOnProperty(name="spring.profiles.active", havingValue = "dev")
public class AccessLogFilter implements Filter {

    private static final Log logger = LogFactory.getLog(AccessLogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("启动：AccessLogFilter过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String uri = req.getRequestURI();
        if (uri == null || uri.endsWith(".js") || uri.endsWith(".css") || uri.endsWith(".html") || uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".gif")) { //过滤静态文件访问
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse res = (HttpServletResponse) servletResponse;
            logger.info("ACCESS LOG: ");
            logger.info("请求路径: " + uri);
            logger.info("请求时间: " + new Date());
            filterChain.doFilter(servletRequest, servletResponse);
            logger.info("返回状态: " + res.getStatus());
        }
    }

    @Override
    public void destroy() {
    }
}
