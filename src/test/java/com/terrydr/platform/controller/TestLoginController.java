package com.terrydr.platform.controller;/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.controller
 * @Description: 测试登陆controller
 * @author: YanZhengYuan
 * @Date: 6/5/2018 4:46 PM
 * @version: 1.00
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.terrydr.TerrydrOSSApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

/**
 * @desc 描述 <br>
 * <p>
 * Copyright: Copyright (c)
 * <p>
 * Company: 南京泰立瑞信息科技有限公司
 * <p>
 * @author zyyan@terrydr.com
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TerrydrOSSApplication.class)
public class TestLoginController {

    private Logger log = LoggerFactory.getLogger(TestLoginController.class);

    MockMvc mvc;

    @Resource
    WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws JsonProcessingException {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testShow() throws Exception {
        String expectedResult = "5 seconds later";
        String uri = "/login";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();

        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        Assert.assertFalse("错误，正确的返回值为200", status != 200);
        Assert.assertTrue("数据一致", expectedResult.equals(content));
        Assert.assertFalse("数据不一致", !expectedResult.equals(content));
    }
}
