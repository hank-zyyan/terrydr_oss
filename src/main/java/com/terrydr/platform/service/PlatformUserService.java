package com.terrydr.platform.service;

import com.terrydr.platform.domain.PlatformUser;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.service
 * @Description: OSS 平台用户服务
 * @author: YanZhengYuan
 * @Date: 6/12/2018 8:26 PM
 * @version: 1.00
 */
public interface PlatformUserService {

    /**
    * @Description: 根据用户名，查询用户
    * @param username
    * @return PlatformUser
    * @throws
    * @author YanZhengYaun
    * @date 6/12/2018 8:39 PM
    */
    PlatformUser getPlatformUserByUsername(String username);

    /**
     * @Description: 根据用户名，查询用户(登陆用)
     * @param username
     * @return PlatformUser
     * @throws
     * @author YanZhengYaun
     * @date 6/12/2018 8:39 PM
     */
    PlatformUser getLoginUserByUsername(String username);
}
