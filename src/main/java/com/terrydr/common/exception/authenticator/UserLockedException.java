package com.terrydr.common.exception.authenticator;

import com.terrydr.common.exception.OSSException;
import org.apache.shiro.authc.AuthenticationException;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.exception.authenticator
 * @Description: 用户被锁定
 * @author: YanZhengYuan
 * @Date: 6/13/2018 10:54 AM
 * @version: 1.00
 */
public class UserLockedException extends AuthenticationException {
    public UserLockedException() {
    }

    public UserLockedException(String message) {
        super(message);
    }

    public UserLockedException(Throwable cause) {
        super(cause);
    }

    public UserLockedException(String message, Throwable cause) {
        super(message, cause);
    }
}
