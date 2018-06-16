package com.terrydr.common.utils;

import com.terrydr.common.exception.service.NullParameterException;
import com.terrydr.common.exception.service.ServiceNotFoundException;
import com.terrydr.common.service.CacheService;
import com.terrydr.platform.service.PlatformMenuService;
import com.terrydr.platform.service.PlatformRoleService;
import com.terrydr.platform.service.PlatformUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.utils
 * @Description: OSS Service Context
 * @author: YanZhengYuan
 * @Date: 6/12/2018 5:21 PM
 * @version: 1.00
 */
@Component
public class ServiceContext {

    private static final Log logger = LogFactory.getLog(ServiceContext.class);

    //所有的服务
    private Map<Class, Object> serviceMap = new HashMap<>();

    /**
     * 获取服务
     * @param T
     * @param <T>
     * @return
     */
    public <T> T getService(Class<? super T> T){
        Object service = serviceMap.get(T);
        if(service != null){
            return (T)service;
        }
        throw new ServiceNotFoundException(T.getName());
    }

    /**
     * 注入服务
     * @param T
     * @param object
     */
    public void setService(Class T, Object object){
        if(object == null){
            throw new NullParameterException("Object");
        }
        if(T == null){
            throw new NullParameterException("Class");
        }
        serviceMap.put(T, object);
    }

    @Autowired
    public void setCacheService(CacheService cacheService) {
        setService(CacheService.class, cacheService);
    }

    @Autowired
    public void setPlatformUserService(PlatformUserService platformUserService) {
        setService(PlatformUserService.class, platformUserService);
    }

    @Autowired
    public void setPlatformMenuService(PlatformMenuService platformMenuService) {
        setService(PlatformMenuService.class, platformMenuService);
    }

    @Autowired
    public void setPlatformRoleService(PlatformRoleService platformRoleService) {
        setService(PlatformRoleService.class, platformRoleService);
    }
}
