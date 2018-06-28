package com.terrydr.platform.controller;

import com.terrydr.common.utils.OSSContext;
import com.terrydr.common.utils.PageUtils;
import com.terrydr.common.utils.QueryUtils;
import com.terrydr.platform.domain.PlatformUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.controller
 * @Description: 平台操作日志控制器
 * @author: YanZhengYuan
 * @Date: 2018/6/28 9:38
 * @version: 1.00
 */
@Controller
@RequestMapping("/platform/log")
public class LogController {

    private static final Log logger = LogFactory.getLog(LogController.class);

    /** 页面跳转 **/

    /**
     * 跳转：系统日志查询页面
     * @return
     */
    @GetMapping(produces = {MediaType.TEXT_HTML_VALUE})
    String log() {
        return "platform/log/log";
    }

    /** 数据返回 **/

    /**
     * 日志列表数据
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

}
