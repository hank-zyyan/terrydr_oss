package com.terrydr.platform.service;

import com.terrydr.platform.domain.PlatformUser;

import java.util.List;
import java.util.Map;

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

    PlatformUser getPlatformUserByUsername(String username);

    PlatformUser getLoginUserByUsername(String username);

    List<PlatformUser> getAllUsers();

    List<PlatformUser> getUsersByParams(Map<String, Object> params);

    long countAll();

    long countByParams(Map<String, Object> params);

    int forbidUser(Integer id);

    int forbidUsers(Integer... ids);

    int startUser(Integer id);

    int startUsers(Integer... ids);
}
