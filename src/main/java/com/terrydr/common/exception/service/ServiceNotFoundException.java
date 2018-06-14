package com.terrydr.common.exception.service;

import com.terrydr.common.exception.OSSException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception.service
 * @Description: 找不到服务异常
 * @author: YanZhengYuan
 * @Date: 6/12/2018 5:35 PM
 * @version: 1.00
 */
public class ServiceNotFoundException extends OSSException{

    public ServiceNotFoundException() {
    }

    public ServiceNotFoundException(String message) {
        super("找不到指定的服务:" + message);
    }

    public ServiceNotFoundException(String message, Throwable cause) {
        super("找不到指定的服务:" + message, cause);
    }

    public ServiceNotFoundException(Throwable cause) {
        super(cause);
    }

    public ServiceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("找不到指定的服务:" + message, cause, enableSuppression, writableStackTrace);
    }
}
