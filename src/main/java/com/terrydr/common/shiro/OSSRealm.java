package com.terrydr.common.shiro;

import com.terrydr.platform.dao.PlatformUserDAO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.shiro
 * @Description: 自定义鉴权验证逻辑
 * @author: YanZhengYuan
 * @Date: 2018/4/18 13:54
 * @version: 1.00
 */
@Component
public class OSSRealm extends AuthorizingRealm {

    @Resource
    private PlatformUserDAO platformUserDAO;

    /**
    * @Description: 自定义角色逻辑
    * @param principalCollection
    * @return AuthorizationInfo
    * @throws
    * @author YanZhengYaun
    * @date 2018/4/18 13:55
    */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
    * @Description: 自定义登陆逻辑
    * @param authenticationToken
    * @return AuthenticationInfo
    * @throws
    * @author YanZhengYaun
    * @date 2018/4/18 13:57
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        authenticationToken.getPrincipal();
        return null;
    }
}
