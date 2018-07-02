package com.terrydr.eye.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.eye.controller
 * @Description: 患者管理控制器
 * @author: YanZhengYuan
 * @Date: 7/2/2018 4:47 PM
 * @version: 1.00
 */
@Controller
@RequestMapping("/eye/customer")
public class CustomerController {

    private static final Log logger = LogFactory.getLog(CustomerController.class);

    /** 页面跳转 **/

    /**
     * 跳转：患者列表页面
     * @return
     */
    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public String customer(){
        return "eye/customer/customer";
    }

}
