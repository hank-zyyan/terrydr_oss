package com.terrydr.platform.service;

import com.terrydr.platform.domain.MenuTree;

import java.util.List;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.service
 * @Description: 平台菜单服务
 * @author: YanZhengYuan
 * @Date: 6/13/2018 2:29 PM
 * @version: 1.00
 */
public interface PlatformMenuService {

    List<MenuTree> getUserMenu();

}
