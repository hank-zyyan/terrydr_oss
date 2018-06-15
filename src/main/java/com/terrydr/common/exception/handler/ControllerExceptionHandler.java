package com.terrydr.common.exception.handler;

import com.terrydr.common.domain.Response;
import com.terrydr.common.exception.OSSException;
import com.terrydr.common.utils.Constant;
import com.terrydr.common.utils.HttpUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception.handler
 * @Description: Controller层异常捕捉处理
 * @author: YanZhengYuan
 * @Date: 6/14/2018 2:29 PM
 * @version: 1.00
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Log logger = LogFactory.getLog(ControllerExceptionHandler.class);

    @ExceptionHandler(AuthorizationException.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handleAuthorizationException(AuthorizationException e, HttpServletRequest request) {
        logger.error(e.getMessage(), e);

        if (HttpUtil.isAjax(request)) {
            return Response.fail("未授权", Constant.ResponseCode.FOBBIDEN);
        }

        return new ModelAndView("error/403");
    }

    @ExceptionHandler({OSSException.class})
    @ResponseStatus(HttpStatus.OK)
    public Object handleOSSException(Exception e, HttpServletRequest request) {
        logger.error(e.getMessage(), e);

        if (HttpUtil.isAjax(request)) {
            return Response.fail("平台错误，请联系管理员", Constant.ResponseCode.INNER_ERROR);
        }

        return new ModelAndView("error/500");
    }


    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.OK)
    public Object handleException(Exception e, HttpServletRequest request) {
        logger.error(e.getMessage(), e);

        if (HttpUtil.isAjax(request)) {
            return Response.fail("未知错误，请联系开发者", Constant.ResponseCode.INNER_ERROR);
        }

        return new ModelAndView("error/500");
    }
}
