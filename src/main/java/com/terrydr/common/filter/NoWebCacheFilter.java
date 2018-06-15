package com.terrydr.common.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.filter
 * @Description: 前端页面禁止缓存
 * @author: YanZhengYuan
 * @Date: 6/15/2018 10:03 AM
 * @version: 1.00
 */

@WebFilter
@Component
@ConditionalOnProperty(name="spring.thymeleaf.cache", havingValue = "false")
public class NoWebCacheFilter implements Filter {

    private static final Log logger = LogFactory.getLog(NoWebCacheFilter.class);

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) res;
        resp.setHeader("Pragma", "No-cache");
        resp.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.addDateHeader("expires", -1);
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig arg0) {
        logger.info("启动：NoWebCacheFilter过滤器");
    }

}
