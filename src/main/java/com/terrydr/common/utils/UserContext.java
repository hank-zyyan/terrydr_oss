package com.terrydr.common.utils;/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.common.utils
 * @Description: 用户上下文
 * @author: YanZhengYuan
 * @Date: 6/4/2018 1:03 PM
 * @version: 1.00
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @author zyyan@terrydr.com
 * @version 1.0.0
 * @desc 用户上下文 <br>
 * <p>
 * Copyright: Copyright (c)
 * <p>
 * Company: 南京泰立瑞信息科技有限公司
 * <p>
 */
public class UserContext {

    public static String getAccessToken() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        return session != null ? session.getId().toString() : null;
    }

}
