package com.terrydr.platform.controller;

import com.terrydr.common.domain.Response;
import com.terrydr.common.exception.authenticator.UserLockedException;
import com.terrydr.common.exception.authenticator.UserNotExistsException;
import com.terrydr.common.exception.authenticator.WrongVerifyCodeException;
import com.terrydr.common.utils.OSSContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.controller
 * @Description: 登陆控制器
 * @author: YanZhengYuan
 * @Date: 2018/4/17 11:19
 * @version: 1.00
 */
@Controller
public class LoginController {

    private static final Log logger = LogFactory.getLog(LoginController.class);

    @RequestMapping(value = "/", produces = {MediaType.TEXT_HTML_VALUE})
    public String defaultPath(){
        return "redirect:index";
    }

    @RequestMapping(value = "/index", produces = {MediaType.TEXT_HTML_VALUE})
    public String welcome(Model model){
        model.addAttribute("menus", OSSContext.getPlatformMenuService().getUserMenu());
        return "index_v1";
    }

    /** login section **/

    @PostMapping(value="/login")
    @ResponseBody
    public Response ajaxLogin(String username, String password, String verifyCode){
        logger.debug(OSSContext.isAuthenticated());

        logger.debug(OSSContext.getCurrentUser());

        try {
            OSSContext.login(username, password, verifyCode);
        }catch (WrongVerifyCodeException | UserNotExistsException | UserLockedException ae){
            return Response.fail(ae.getMessage());
        } catch (AuthenticationException ae){
            return Response.fail("用户名或密码错误");
        }

        logger.debug(OSSContext.getCurrentUser());

        logger.debug(OSSContext.getAccessToken());

        return Response.success(OSSContext.getAccessToken(), null);
    }

    @GetMapping(value="/login",produces = {MediaType.TEXT_HTML_VALUE})
    public String loginPage(){
        return "login";
    }

    /** logout section **/

    @GetMapping(value="/logout",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Response appLogout() {
        OSSContext.logout();
        return Response.success();
    }

    @GetMapping(value="/logout",produces = {MediaType.TEXT_HTML_VALUE})
    public String webLogout() {
        OSSContext.logout();
        return "redirect:/login";
    }
}
