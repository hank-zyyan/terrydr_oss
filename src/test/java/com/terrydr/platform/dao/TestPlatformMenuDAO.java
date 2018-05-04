package com.terrydr.platform.dao;

import com.terrydr.platform.domain.PlatformMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.dao
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 2018/4/16 14:59
 * @version: 1.00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestPlatformMenuDAO {

    @Resource
    private PlatformMenuDAO menuDAO;

    @Resource
    private EhCacheCacheManager cacheManager;

    @Test
    public void test(){
        PlatformMenu menu = menuDAO.selectByPrimaryKey(1);
        cacheManager.getCache("verifyCode");
        System.out.println(menu.getMenuName());
    }

}
