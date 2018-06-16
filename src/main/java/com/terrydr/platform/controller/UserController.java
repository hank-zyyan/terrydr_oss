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
import org.springframework.ui.Model;
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
     * 跳转：用户列表页面
     * @return
     */
    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public String user(){
        return "platform/user/user";
    }

    /**
     * 跳转：添加用户页面
     * @return
     */
    @GetMapping(value="add", produces = {MediaType.TEXT_HTML_VALUE})
    public String add(Model model){
        model.addAttribute("roles", OSSContext.getPlatformRoleService().getAllRoleIdAndDesc());
        return "platform/user/add";
    }

    /**
     * 跳转：编辑用户页面
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("user", OSSContext.getPlatformUserService().getUserById(id));
        model.addAttribute("roles", OSSContext.getPlatformRoleService().getAllRoleIdAndDesc());
        return "platform/user/edit";
    }

    /**
     * 修改密码
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/resetPwd/{id}")
    public String resetPwd(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", OSSContext.getPlatformUserService().getUserById(id));
        return "platform/user/reset_pwd";
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
    public Response batchRemove(@RequestParam("ids[]") Integer[] ids){
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
    public Response batchStart(@RequestParam("ids[]") Integer[] ids){
        if (OSSContext.getPlatformUserService().startUsers(ids) > 0) {
            return Response.success();
        } else {
            return Response.fail("更新未生效");
        }
    }

    /**
     * 保存用户
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Response save(PlatformUser user){
        if (OSSContext.getPlatformUserService().saveUser(user) > 0) {
            return Response.success();
        } else {
            return Response.fail("保存失败");
        }
    }

    /**
     * 存在返回false
     * @param userName
     * @return
     */
    @PostMapping("/exist")
    @ResponseBody
    public boolean exist(String userName) {
        return !OSSContext.getPlatformUserService().exist(userName);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    public Response update(PlatformUser user) {
        if (OSSContext.getPlatformUserService().updateUser(user) > 0) {
            return Response.success();
        } else {
            return Response.fail("更新未生效");
        }
    }

    /**
     * 管理员重置账号密码
     * @param id
     * @param password
     * @return
     */
    @PostMapping("/adminResetPwd")
    @ResponseBody
    public Response adminResetPwd(Integer id, String password) {
        if (OSSContext.getPlatformUserService().adminResetPwd(id, password) > 0) {
            return Response.success();
        } else {
            return Response.fail("更新未生效");
        }
    }
}
