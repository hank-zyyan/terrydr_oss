package com.terrydr.common.shiro;

import com.terrydr.common.exception.authenticator.UserLockedException;
import com.terrydr.common.exception.authenticator.UserNotExistsException;
import com.terrydr.common.exception.authenticator.WrongPWDException;
import com.terrydr.common.exception.authenticator.WrongVerifyCodeException;
import com.terrydr.common.utils.OSSContext;
import com.terrydr.platform.domain.PlatformUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;


/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.shiro
 * @Description: 自定义鉴权验证逻辑
 * @author: YanZhengYuan
 * @Date: 2018/4/18 13:54
 * @version: 1.00
 */
public class OSSVerifyCodeRealm extends AuthorizingRealm {

    private static final Log logger = LogFactory.getLog(OSSVerifyCodeRealm.class);

    /**
     * @param principalCollection
     * @return AuthorizationInfo
     * @throws
     * @Description: 自定义角色逻辑
     * @author YanZhengYaun
     * @date 2018/4/18 13:55
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * @param authenticationToken
     * @return AuthenticationInfo
     * @throws
     * @Description: 自定义登陆逻辑
     * @author YanZhengYaun
     * @date 2018/4/18 13:57
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        OSSVerifyCodeToken token;
        //判断是否用自定义token
        if(authenticationToken instanceof OSSVerifyCodeToken){
            token = (OSSVerifyCodeToken)authenticationToken;
        }else{
            logger.warn("不匹配的token");
            throw new UnknownAccountException("用户名或密码错误");
        }
        logger.debug("Principal:" + token.getPrincipal());
        logger.debug("VerifyCode:" + token.getVerifyCode());

        //1.判断验证码是否一致
        if(token.getVerifyCode() == null || !token.getVerifyCode().equals(OSSContext.getVerifyCode())){
            logger.info("验证码错误");
            throw new WrongVerifyCodeException("用户名或密码错误");
        }

        //2.判断用户是否存在
        PlatformUser user = OSSContext.getPlatformUserService().getLoginUserByUsername(token.getPrincipal().toString());
        if(user == null){
            logger.info("用户不存在");
            throw new UserNotExistsException("用户名或密码错误");
        }

        //3.判断用户密码是否一致
        String password = new String((char[]) token.getCredentials());
        logger.debug("pwd:" + password);
        logger.debug("pwdInDB:" + user.getUserPwd());
        if(!user.getUserPwd().equals(password)){
            logger.info("用户输入密码错误");
            throw new WrongPWDException("用户名或密码错误");
        }

        //4.判断用户是否锁定
        if("0".equals(user.getStatus())){
            logger.info("用户被锁定");
            throw new UserLockedException("账号已锁定，请联系管理员");
        }

        return new SimpleAuthenticationInfo(user, user.getUserPwd(), getName());
    }
}
