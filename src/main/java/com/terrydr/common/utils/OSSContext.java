package com.terrydr.common.utils;

import com.terrydr.common.service.CacheService;
import com.terrydr.platform.domain.PlatformUser;
import com.terrydr.platform.properties.PlatformDataSourceProperties;
import com.terrydr.platform.service.PlatformMenuService;
import com.terrydr.platform.service.PlatformUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
@Order(1)
public class OSSContext {

    private static UserContext userContext;

    private static ServiceContext serviceContext;

    private static PropertiesContext propertiesContext;

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

    /** user section **/

    public static PlatformUser getCurrentUser(){
        return userContext.getCurrentUser();
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

    /** property section **/

    public static PlatformDataSourceProperties getPlatformDataSourceProperties(){
        return propertiesContext.getPropery(PlatformDataSourceProperties.class);
    }
}
