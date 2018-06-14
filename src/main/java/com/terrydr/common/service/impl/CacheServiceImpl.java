package com.terrydr.common.service.impl;

import com.terrydr.common.service.CacheService;
import com.terrydr.common.utils.Constant;
import com.terrydr.common.utils.OSSContext;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.service.impl
 * @Description: 缓存服务实现
 * @author: YanZhengYuan
 * @Date: 6/12/2018 3:41 PM
 * @version: 1.00
 */

@Service
public class CacheServiceImpl implements CacheService{

    @Resource
    private CacheManager springCacheManager;

    @Override
    public <T> T getValue(Object key, String cacheName, Class<T> type) {
        Cache cache = springCacheManager.getCache(cacheName);
        return cache.get(key, type);
    }

    @Override
    public void putValue(Object key, Object value, String cacheName) {
        Cache cache = springCacheManager.getCache(cacheName);
        cache.put(key, value);
    }

}
