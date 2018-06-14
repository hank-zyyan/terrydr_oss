package com.terrydr.common.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.shiro
 * @Description: 自定义token，兼容验证码
 * @author: YanZhengYuan
 * @Date: 6/12/2018 4:56 PM
 * @version: 1.00
 */
public class OSSVerifyCodeToken extends UsernamePasswordToken{

    public OSSVerifyCodeToken(String username, String password, String verifyCode) {
        super(username, password);
        this.verifyCode = verifyCode;
    }

    private String verifyCode;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "OSSVerifyCodeToken{" +
                "verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
