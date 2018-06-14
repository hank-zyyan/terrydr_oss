package com.terrydr.common.utils;

import com.terrydr.common.exception.service.NullParameterException;
import com.terrydr.common.exception.service.ProperyFileNotFoundException;
import com.terrydr.platform.properties.PlatformDataSourceProperties;
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
 * @Description: 配置Context
 * @author: YanZhengYuan
 * @Date: 6/13/2018 8:47 AM
 * @version: 1.00
 */
@Component
public class PropertiesContext {

    private static final Log logger = LogFactory.getLog(PropertiesContext.class);

    private Map<Class, Object> propertiesMap = new HashMap<>();

    public <T> T getPropery(Class<T> T){
        Object pro = propertiesMap.get(T);
        if(pro != null){
            return (T)pro;
        }
        throw new ProperyFileNotFoundException(T.getName());
    }

    public void setPropery(Class T, Object object){
        if(object == null){
            throw new NullParameterException("Object");
        }
        if(T == null){
            throw new NullParameterException("Class");
        }
        propertiesMap.put(T, object);
    }

    @Autowired
    public void setPlatformDataSourceProperties(PlatformDataSourceProperties platformDataSourceProperties) {
        setPropery(PlatformDataSourceProperties.class, platformDataSourceProperties);
    }
}
