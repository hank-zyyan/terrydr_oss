package com.terrydr.common.exception.service;

import com.terrydr.common.exception.OSSException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception.service
 * @Description: 参数为空异常
 * @author: YanZhengYuan
 * @Date: 6/12/2018 5:46 PM
 * @version: 1.00
 */
public class NullParameterException extends OSSException {
    public NullParameterException() {
    }

    public NullParameterException(String message) {
        super(message + "参数为空");
    }

    public NullParameterException(String message, Throwable cause) {
        super(message + "参数为空", cause);
    }

    public NullParameterException(Throwable cause) {
        super(cause);
    }

    public NullParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message + "参数为空", cause, enableSuppression, writableStackTrace);
    }
}
