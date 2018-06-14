package com.terrydr.common.utils;

import com.terrydr.common.shiro.OSSVerifyCodeToken;
import com.terrydr.platform.domain.PlatformUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.utils
 * @Description: 用户上下文
 * @author: YanZhengYuan
 * @Date: 6/4/2018 1:03 PM
 * @version: 1.00
 */
@Component
public class UserContext {

    public PlatformUser getCurrentUser(){
        return (PlatformUser)getSubject().getPrincipal();
    }

    public boolean isAuthenticated(){
        return getSubject().isAuthenticated();
    }

    public String getAccessToken() {
        Session session = getSubject().getSession();
        return session != null ? session.getId().toString() : null;
    }

    public void login(String username, String password, String verifyCode){
        String hashedPwd = MD5.getMD5(password);
        OSSVerifyCodeToken token = new OSSVerifyCodeToken(username, hashedPwd, verifyCode);
        getSubject().login(token);
    }

    public void logout() {
        getSubject().logout();
    }

    private Subject getSubject(){
        return SecurityUtils.getSubject();
    }

}
