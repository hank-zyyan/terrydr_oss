package com.terrydr.platform.config.cache;

import com.terrydr.common.utils.OSSContext;
import com.terrydr.platform.domain.PlatformRole;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.config.cache
 * @Description: 自定义平台菜单缓存Key生成策略
 * @author: YanZhengYuan
 * @Date: 6/13/2018 3:48 PM
 * @version: 1.00
 */
@Component
public class UpLoadedRoleIdKeyGen implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        for(Object obj : params){
            if(obj instanceof PlatformRole){
                PlatformRole role = (PlatformRole)obj;
                return role.getId();
            }
        }
        return null;
    }

}
