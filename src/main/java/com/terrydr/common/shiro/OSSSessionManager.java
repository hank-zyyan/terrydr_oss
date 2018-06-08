package com.terrydr.common.shiro;


import com.terrydr.common.utils.Constant;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.shiro
 * @Description: 自定义session manager
 * @author: YanZhengYuan
 * @Date: 2018/5/4 14:45
 * @version: 1.00
 */
public class OSSSessionManager extends DefaultWebSessionManager {

    /**
    * @Description: 重写session获取逻辑
    * @param request
    * @param response
    * @return Serializable
    * @throws
    * @author YanZhengYaun
    * @date 2018/5/4 14:47
    */
    @Override
    public Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String id = WebUtils.toHttp(request).getHeader(Constant.ACCESS_TOKEN_KEY);
        //如果请求头中有 ACCESS_TOKEN_KEY 则其值为sessionId
        if (!StringUtils.isEmpty(id)) {
            return id;
        } else {
            //否则按默认规则从cookie取sessionId
            return super.getSessionId(request, response);
        }
    }
}
