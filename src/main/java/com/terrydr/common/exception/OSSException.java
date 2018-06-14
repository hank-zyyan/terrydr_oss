package com.terrydr.common.exception;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception
 * @Description: OSS 根异常
 * @author: YanZhengYuan
 * @Date: 6/12/2018 5:33 PM
 * @version: 1.00
 */
public class OSSException extends RuntimeException{
    public OSSException() {
    }

    public OSSException(String message) {
        super(message);
    }

    public OSSException(String message, Throwable cause) {
        super(message, cause);
    }

    public OSSException(Throwable cause) {
        super(cause);
    }

    public OSSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
