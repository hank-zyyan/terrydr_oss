package com.terrydr.common.exception.service;

import com.terrydr.common.exception.OSSException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception.service
 * @Description: 参数格式不正确
 * @author: YanZhengYuan
 * @Date: 6/12/2018 5:46 PM
 * @version: 1.00
 */
public class ErrorParameterException extends OSSException {
    public ErrorParameterException() {
    }

    public ErrorParameterException(String message) {
        super(message + "参数错误");
    }

    public ErrorParameterException(String message, Throwable cause) {
        super(message + "参数错误", cause);
    }

    public ErrorParameterException(Throwable cause) {
        super(cause);
    }

    public ErrorParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message + "参数错误", cause, enableSuppression, writableStackTrace);
    }
}
