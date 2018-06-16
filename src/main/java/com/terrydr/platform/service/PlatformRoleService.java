package com.terrydr.platform.service;

import com.terrydr.platform.domain.PlatformRole;

import java.util.List;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.service
 * @Description: 平台角色服务
 * @author: YanZhengYuan
 * @Date: 2018/6/16 12:06
 * @version: 1.00
 */
public interface PlatformRoleService {
    List<PlatformRole> getAllRoleIdAndDesc();
}
