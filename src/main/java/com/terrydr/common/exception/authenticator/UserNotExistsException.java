package com.terrydr.common.exception.authenticator;

import org.apache.shiro.authc.AuthenticationException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception.authenticator
 * @Description: 登陆的用户不存在
 * @author: YanZhengYuan
 * @Date: 6/13/2018 10:52 AM
 * @version: 1.00
 */
public class UserNotExistsException extends AuthenticationException {
    public UserNotExistsException() {
    }

    public UserNotExistsException(String message) {
        super(message);
    }

    public UserNotExistsException(Throwable cause) {
        super(cause);
    }

    public UserNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
