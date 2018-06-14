package com.terrydr.common.exception.handler;

import com.terrydr.common.domain.Response;
import com.terrydr.common.utils.Constant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.controller
 * @Description: 全局捕捉Error/Exception，并将请求forward给指定路径
 * @author: YanZhengYuan
 * @Date: 6/14/2018 1:29 PM
 * @version: 1.00
 */

@Controller
public class OSSErrorController implements ErrorController{

    private static final Log logger = LogFactory.getLog(OSSErrorController.class);

    /**
     * web跳转
     * @param request
     * @return
     */
    @RequestMapping(value = Constant.ERROR_PATH, produces = {MediaType.TEXT_HTML_VALUE})
    @ResponseStatus(code= HttpStatus.OK)
    public String webError(HttpServletRequest request){
        return handlerError(request).getResponseMessage();
    }

    /**
     * app跳转
     * @param request
     * @return
     */
    @RequestMapping(value = Constant.ERROR_PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(code= HttpStatus.OK)
    @ResponseBody
    public Object appError(HttpServletRequest request){
        return handlerError(request).getResponseObject();
    }

    @Override
    public String getErrorPath() {
        return Constant.ERROR_PATH;
    }

    /**
     * 具体的处理
     * @param request
     * @return
     */
    private Response handlerError(HttpServletRequest request) {
        Response message;
        HttpStatus status = getStatus(request);
        if(status == HttpStatus.UNAUTHORIZED) {
            logger.error("未认证");
            message = Response.fail("/login", Response.fail("未认证", Constant.ResponseCode.NOTAUTHENTICATED));
        } else if(status == HttpStatus.FORBIDDEN) {
            logger.error("未授权");
            message = Response.fail("/error/403", Response.fail("未授权", Constant.ResponseCode.FUBBIDEN));
        } else if(status == HttpStatus.NOT_FOUND) {
            logger.error("404错误");
            message = Response.fail("/error/404", Response.fail("找不到页面", Constant.ResponseCode.NOTFOUND));
        } else {
            logger.error("系统错误");
            message = Response.fail("/error/500", Response.fail("服务器错误，请联系管理员", Constant.ResponseCode.INNER_ERROR));
        }
        return message;
    }

    /**
     * 获取错误编码
     * @param  request
     * @return HttpStatus
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        }
        catch (Exception ex) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}
