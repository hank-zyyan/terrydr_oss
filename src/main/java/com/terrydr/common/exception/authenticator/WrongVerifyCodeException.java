package com.terrydr.common.exception.authenticator;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception.authenticator
 * @Description: 错误的验证码
 * @author: YanZhengYuan
 * @Date: 6/13/2018 10:51 AM
 * @version: 1.00
 */
public class WrongVerifyCodeException extends AuthenticationException {
    public WrongVerifyCodeException() {
    }

    public WrongVerifyCodeException(String message) {
        super(message);
    }

    public WrongVerifyCodeException(Throwable cause) {
        super(cause);
    }

    public WrongVerifyCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
