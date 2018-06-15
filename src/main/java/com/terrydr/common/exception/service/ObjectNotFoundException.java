package com.terrydr.common.exception.service;

import com.terrydr.common.exception.OSSException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception.service
 * @Description: 找不到对象异常
 * @author: YanZhengYuan
 * @Date: 6/12/2018 5:35 PM
 * @version: 1.00
 */
public class ObjectNotFoundException extends OSSException{

    public ObjectNotFoundException() {
    }

    public ObjectNotFoundException(String message) {
        super("找不到指定的对象:" + message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super("找不到指定的对象:" + message, cause);
    }

    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }

    public ObjectNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("找不到指定的对象:" + message, cause, enableSuppression, writableStackTrace);
    }
}
