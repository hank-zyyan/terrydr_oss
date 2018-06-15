package com.terrydr.platform.controller;

import com.terrydr.common.domain.Response;
import com.terrydr.common.utils.OSSContext;
import com.terrydr.common.utils.PageUtils;
import com.terrydr.common.utils.QueryUtils;
import com.terrydr.platform.domain.PlatformUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.controller
 * @Description: 用户管理控制器
 * @author: YanZhengYuan
 * @Date: 6/15/2018 2:37 PM
 * @version: 1.00
 */

@Controller
@RequestMapping("/platform/user")
public class UserController {

    private static final Log logger = LogFactory.getLog(UserController.class);

    /** 页面跳转 **/

    /**
     * 跳转：菜单配置页面
     * @return
     */
    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public String user(){
        return "platform/user/user";
    }


    /** 数据返回 **/

    /**
     * 用户列表数据
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public PageUtils list(@RequestParam Map<String, Object> params){
        // 查询列表数据
        QueryUtils query = new QueryUtils(params);
        List<PlatformUser> usersList = OSSContext.getPlatformUserService().getUsersByParams(query);
        long total = OSSContext.getPlatformUserService().countByParams(query);
        PageUtils pageUtil = new PageUtils(usersList, total);
        return pageUtil;
    }

    /**
     * 禁用用户
     * @return
     */
    @PostMapping("/remove")
    @ResponseBody
    public Response remove(Integer id){
        if (OSSContext.getPlatformUserService().forbidUser(id) > 0) {
            return Response.success();
        } else {
            return Response.fail("更新未生效");
        }
    }

    /**
     * 启用用户
     * @return
     */
    @PostMapping("/start")
    @ResponseBody
    public Response start(Integer id){
        if (OSSContext.getPlatformUserService().startUser(id) > 0) {
            return Response.success();
        } else {
            return Response.fail("更新未生效");
        }
    }

    /**
     * 批量禁用用户
     * @return
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    public Response batchRemove(@RequestParam("ids") Integer[] ids){
        if (OSSContext.getPlatformUserService().forbidUsers(ids) > 0) {
            return Response.success();
        } else {
            return Response.fail("更新未生效");
        }
    }

    /**
     * 批量启用用户
     * @return
     */
    @PostMapping("/batchStart")
    @ResponseBody
    public Response batchStart(@RequestParam("ids") Integer[] ids){
        if (OSSContext.getPlatformUserService().startUsers(ids) > 0) {
            return Response.success();
        } else {
            return Response.fail("更新未生效");
        }
    }

}
