package com.terrydr.common.utils;

import com.terrydr.common.service.CacheService;
import com.terrydr.platform.domain.PlatformUser;
import com.terrydr.platform.properties.PlatformDataSourceProperties;
import com.terrydr.platform.service.PlatformLogService;
import com.terrydr.platform.service.PlatformMenuService;
import com.terrydr.platform.service.PlatformRoleService;
import com.terrydr.platform.service.PlatformUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.utils
 * @Description: OSS上下文
 * @author: YanZhengYuan
 * @Date: 2018/4/18 14:19
 * @version: 1.00
 */
@Component
public class OSSContext {

    private static UserContext userContext;

    private static ServiceContext serviceContext;

    private static PropertiesContext propertiesContext;

    private static HttpContext httpContext;

    @Autowired
    public void setPropertiesContext(PropertiesContext propertiesContext) {
        OSSContext.propertiesContext = propertiesContext;
    }

    @Autowired
    public void setServiceContext(ServiceContext serviceContext) {
        OSSContext.serviceContext = serviceContext;
    }

    @Autowired
    public void setUserContext(UserContext userContext) {
        OSSContext.userContext = userContext;
    }

    @Autowired
    public void setHttpContext(HttpContext httpContext) {
        OSSContext.httpContext = httpContext;
    }

    /** user section **/

    public static PlatformUser getCurrentUser(){
        return userContext.getCurrentUser();
    }

    public static boolean hasRole(Integer roleId){
        return userContext.hasRole(roleId);
    }

    public static boolean hasRole(String roleName){
        return userContext.hasRole(roleName);
    }

    public static boolean isAuthenticated(){
        return userContext.isAuthenticated();
    }

    public static String getAccessToken(){
        return userContext.getAccessToken();
    }

    public static void login(String username, String password, String verifyCode){
        userContext.login(username, password, verifyCode);
    }

    public static void logout(){
        userContext.logout();
    }

    public static void saveVerifyCode(Object value){
        getCacheService().putValue(getAccessToken(), value, Constant.VERIFY_CODE_CACHE_NAME);
    }

    public static String getVerifyCode(){
        return getCacheService().getValue(getAccessToken(), Constant.VERIFY_CODE_CACHE_NAME, String.class);
    }

    /** service section **/

    public static CacheService getCacheService(){
        return serviceContext.getService(CacheService.class);
    }

    public static PlatformUserService getPlatformUserService(){
        return serviceContext.getService(PlatformUserService.class);
    }

    public static PlatformMenuService getPlatformMenuService(){
        return serviceContext.getService(PlatformMenuService.class);
    }

    public static PlatformRoleService getPlatformRoleService(){
        return serviceContext.getService(PlatformRoleService.class);
    }

    public static PlatformLogService getPlatformLogService(){
        return serviceContext.getService(PlatformLogService.class);
    }

    /** property section **/

    public static PlatformDataSourceProperties getPlatformDataSourceProperties(){
        return propertiesContext.getPropery(PlatformDataSourceProperties.class);
    }

    /** http section **/

    public static HttpServletRequest getHttpServletRequest() {
        return httpContext.getHttpServletRequest();
    }
}
