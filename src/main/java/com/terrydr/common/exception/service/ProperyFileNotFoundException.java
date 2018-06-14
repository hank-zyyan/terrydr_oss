package com.terrydr.common.exception.service;

import com.terrydr.common.exception.OSSException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception.service
 * @Description: 找不到配置文件异常
 * @author: YanZhengYuan
 * @Date: 6/12/2018 5:35 PM
 * @version: 1.00
 */
public class ProperyFileNotFoundException extends OSSException{

    public ProperyFileNotFoundException() {
    }

    public ProperyFileNotFoundException(String message) {
        super("找不到指定的配置文件:" + message);
    }

    public ProperyFileNotFoundException(String message, Throwable cause) {
        super("找不到指定的配置文件:" + message, cause);
    }

    public ProperyFileNotFoundException(Throwable cause) {
        super(cause);
    }

    public ProperyFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("找不到指定的配置文件:" + message, cause, enableSuppression, writableStackTrace);
    }
}
