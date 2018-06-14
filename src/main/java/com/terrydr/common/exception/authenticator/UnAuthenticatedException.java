package com.terrydr.common.exception.authenticator;

import com.terrydr.common.exception.OSSException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception.authenticator
 * @Description: 未认证异常
 * @author: YanZhengYuan
 * @Date: 6/13/2018 2:32 PM
 * @version: 1.00
 */
public class UnAuthenticatedException extends OSSException{
    public UnAuthenticatedException() {
    }

    public UnAuthenticatedException(String message) {
        super(message);
    }

    public UnAuthenticatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnAuthenticatedException(Throwable cause) {
        super(cause);
    }

    public UnAuthenticatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
