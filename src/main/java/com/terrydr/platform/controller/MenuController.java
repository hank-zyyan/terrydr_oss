package com.terrydr.platform.controller;

import com.terrydr.common.domain.Response;
import com.terrydr.common.utils.OSSContext;
import com.terrydr.platform.domain.JSTree;
import com.terrydr.platform.domain.PlatformMenu;
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
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 6/14/2018 3:54 PM
 * @version: 1.00
 */

@Controller
@RequestMapping("/platform/menu")
public class MenuController {

    private static final Log logger = LogFactory.getLog(MenuController.class);

    /** 页面跳转 **/

    /**
     * 跳转：菜单配置页面
     * @return
     */
    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    public String menu(){
        return "platform/menu/menu";
    }

    /**
    * @Description: 跳转：添加菜单页面
    * @param pId
    * @return String
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 10:55 AM
    */
    @GetMapping(value="/add/{pId}", produces = {MediaType.TEXT_HTML_VALUE})
    public String add(Model model, @PathVariable("pId") Integer pId) {
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", OSSContext.getPlatformMenuService().getMenuNameById(pId));
        }
        return "platform/menu/add";
    }

    /**
    * @Description: 跳转：编辑菜单页面
    * @param id
    * @return String
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 11:25 AM
    */
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id) {
        PlatformMenu menu = OSSContext.getPlatformMenuService().getMenuById(id);
        Integer pId = menu.getParentMenuId();
        model.addAttribute("pId", pId);
        if (pId == 0) {
            model.addAttribute("pName", "根目录");
        } else {
            model.addAttribute("pName", OSSContext.getPlatformMenuService().getMenuNameById(pId));
        }
        model.addAttribute("menu", menu);
        return "platform/menu/edit";
    }

    /** 数据返回 **/

    /**
     * 菜单配置页面数据
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public List<PlatformMenu> list(){
        return OSSContext.getPlatformMenuService().getAllMenus();
    }

    /**
    * @Description: 保存菜单
    * @param menu
    * @return Response
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 10:55 AM
    */
    @PostMapping("/save")
    @ResponseBody
    public Response save(PlatformMenu menu) {
        if (OSSContext.getPlatformMenuService().saveMenu(menu) > 0) {
            return Response.success("保存成功", menu);
        } else {
            return Response.fail("保存失败");
        }
    }

    /**
    * @Description: 禁用菜单
    * @param id
    * @return Response
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 10:54 AM
    */
    @PostMapping("/remove")
    @ResponseBody
    public Response remove(Integer id) {
        if (OSSContext.getPlatformMenuService().forbidMenu(id) > 0) {
            return Response.success();
        } else {
            return Response.fail("更新未生效");
        }
    }

    /**
     * @Description: 启用菜单
     * @param id
     * @return Response
     * @throws
     * @author YanZhengYaun
     * @date 6/15/2018 10:54 AM
     */
    @PostMapping("/start")
    @ResponseBody
    public Response start(Integer id) {
        if (OSSContext.getPlatformMenuService().startMenu(id) > 0) {
            return Response.success();
        } else {
            return Response.fail("更新未生效");
        }
    }

    /**
    * @Description: 更新菜单
    * @param menu
    * @return Response
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 12:19 PM
    */
    @PostMapping("/update")
    @ResponseBody
    public Response update(PlatformMenu menu) {
        if (OSSContext.getPlatformMenuService().updateMenu(menu) > 0) {
            return Response.success();
        } else {
            return Response.fail();
        }
    }

    /**
     * 获得菜单树
     * @return
     */
    @GetMapping("/tree")
    @ResponseBody
    public JSTree tree() {
        JSTree tree = OSSContext.getPlatformMenuService().getEnableMenusTree();
        return tree;
    }

    /**
     * 获得菜单树，并标记已关联的菜单
     * @param roleId
     * @return
     */
    @GetMapping("/tree/{roleId}")
    @ResponseBody
    public JSTree tree(@PathVariable("roleId") Integer roleId) {
        JSTree tree = OSSContext.getPlatformMenuService().getEnableMenusTreeByRoleId(roleId);
        return tree;
    }
}
