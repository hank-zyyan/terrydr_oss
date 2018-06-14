package com.terrydr.platform.dao;

import com.terrydr.TerrydrOSSApplication;
import com.terrydr.platform.domain.PlatformMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest(classes = TerrydrOSSApplication.class)
@Transactional
public class TestPlatformMenuDAO {

    private Logger log = LoggerFactory.getLogger(TestPlatformMenuDAO.class);

    @Resource
    private PlatformMenuDAO menuDAO;

    @Test
    public void test(){
        PlatformMenu menu = menuDAO.selectByPrimaryKey(1);
        log.info(menu.getMenuName());
    }

}
