package com.terrydr.common.cache;

import com.terrydr.platform.domain.PlatformMenu;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.cache
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 2018/5/4 13:27
 * @version: 1.00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCache {

    private Logger log = LoggerFactory.getLogger(TestCache.class);

    @Resource
    private EhCacheCacheManager cacheManager;

    @Test
    public void testEhCache(){
        Cache ehCache = cacheManager.getCache("verifyCode");
        ehCache.put("test","test");
        String value = ehCache.get("test", String.class);
        log.info(value);
    }
}
