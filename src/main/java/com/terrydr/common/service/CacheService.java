package com.terrydr.common.service;

import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.service
 * @Description: 缓存服务接口
 * @author: YanZhengYuan
 * @Date: 6/12/2018 3:39 PM
 * @version: 1.00
 */
public interface CacheService {
    <T> T  getValue(Object key, String cacheName, Class<T> type);

    void putValue(Object key, Object value, String cacheName);

}
