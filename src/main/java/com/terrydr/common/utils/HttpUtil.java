package com.terrydr.common.utils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.utils
 * @Description: HTTP 工具类
 * @author: YanZhengYuan
 * @Date: 6/14/2018 2:56 PM
 * @version: 1.00
 */
public class HttpUtil {

    /**
     * 根据头信息，判断是否为ajax请求
     * @param req
     * @return
     */
    public static boolean isAjax(HttpServletRequest req){
        //判断是否为ajax请求，默认不是
        boolean isAjaxRequest = false;
        if(!StringUtils.isBlank(req.getHeader("x-requested-with")) && req.getHeader("x-requested-with").equals("XMLHttpRequest")){
            isAjaxRequest = true;
        }
        return isAjaxRequest;
    }
}
