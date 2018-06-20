package com.terrydr.platform.controller;

import com.terrydr.common.domain.Response;
import com.terrydr.common.utils.OSSContext;
import com.terrydr.platform.domain.PlatformRole;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.controller
 * @Description: 角色控制器
 * @author: YanZhengYuan
 * @Date: 2018/6/20 14:51
 * @version: 1.00
 */
@Controller
@RequestMapping("/platform/role")
public class RoleController {

    private static final Log logger = LogFactory.getLog(RoleController.class);

    /** 页面跳转 **/

    /**
     * 跳转：角色列表页面
     * @return
     */
    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public String role(){
        return "platform/role/role";
    }

    /**
     * 跳转：添加角色
     * @return
     */
    @GetMapping("/add")
    String add() {
        return "platform/role/add";
    }

    /**
     * 跳转： 编辑角色页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Integer id, Model model) {
        PlatformRole platformRole = OSSContext.getPlatformRoleService().getRoleById(id);
        model.addAttribute("role", platformRole);
        return "platform/role/edit";
    }

    /** 数据返回 **/

    /**
     * 角色列表数据
     * @return
     */
    @GetMapping("/list")
    @ResponseBody()
    List<PlatformRole> list() {
        List<PlatformRole> roles = OSSContext.getPlatformRoleService().getAllRoles();
        return roles;
    }

    @PostMapping("/save")
    @ResponseBody()
    public Response save(PlatformRole role, int[] menuIds) {
        OSSContext.getPlatformRoleService().saveRoleWithAccessableMenus(role, menuIds);
        return Response.success();
    }

    @PostMapping("/update")
    @ResponseBody()
    public Response update(PlatformRole role, int[] menuIds) {
        OSSContext.getPlatformRoleService().updateRoleWithAccessableMenus(role, menuIds);
        return Response.success();
    }

}
