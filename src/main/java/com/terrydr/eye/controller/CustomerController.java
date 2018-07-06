package com.terrydr.eye.controller;

import com.terrydr.common.utils.OSSContext;
import com.terrydr.common.utils.PageUtils;
import com.terrydr.common.utils.QueryUtils;
import com.terrydr.eye.domain.EyeCustomer;
import com.terrydr.platform.domain.PlatformUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    /**
     * 跳转：编辑用户页面
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("customer", OSSContext.getEyeCustomerService().getCustomerById(id));
        return "eye/customer/edit";
    }

    /** 数据返回 **/

    /**
     * 患者列表数据
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public PageUtils list(@RequestParam Map<String, Object> params){
        // 查询列表数据
        QueryUtils query = new QueryUtils(params);
        List<EyeCustomer> customerList = OSSContext.getEyeCustomerService().getCustomersByParams(query);
        long total = OSSContext.getEyeCustomerService().countByParams(query);
        PageUtils pageUtil = new PageUtils(customerList, total);
        return pageUtil;
    }

}
