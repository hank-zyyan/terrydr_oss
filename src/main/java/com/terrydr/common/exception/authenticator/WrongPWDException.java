package com.terrydr.common.exception.authenticator;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception.authenticator
 * @Description: 错误的密码
 * @author: YanZhengYuan
 * @Date: 6/13/2018 10:51 AM
 * @version: 1.00
 */
public class WrongPWDException extends AuthenticationException {
    public WrongPWDException() {
    }

    public WrongPWDException(String message) {
        super(message);
    }

    public WrongPWDException(Throwable cause) {
        super(cause);
    }

    public WrongPWDException(String message, Throwable cause) {
        super(message, cause);
    }
}
