package com.terrydr.platform.service.impl;

import com.terrydr.platform.dao.PlatformRoleDAO;
import com.terrydr.platform.domain.PlatformRole;
import com.terrydr.platform.service.PlatformRoleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.service.impl
 * @Description: 平台角色服务实现类
 * @author: YanZhengYuan
 * @Date: 2018/6/16 12:08
 * @version: 1.00
 */
@Service
public class PlatformRoleServiceImpl implements PlatformRoleService {

    private static final Log logger = LogFactory.getLog(PlatformRoleServiceImpl.class);

    @Resource
    private PlatformRoleDAO platformRoleDAO;

    /**
     * 获取正在启用的所有role的id和desc
     * @return
     */
    @Override
    public List<PlatformRole> getAllRoleIdAndDesc() {
        return platformRoleDAO.selectAllRoleIdAndDesc();
    }
}
