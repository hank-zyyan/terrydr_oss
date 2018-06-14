package com.terrydr.platform.service.impl;

import com.terrydr.common.exception.service.NullParameterException;
import com.terrydr.platform.dao.PlatformUserDAO;
import com.terrydr.platform.domain.PlatformUser;
import com.terrydr.platform.service.PlatformUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.service.impl
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 6/12/2018 8:42 PM
 * @version: 1.00
 */
@Service
public class PlatformUserServiceImpl implements PlatformUserService{

    @Resource
    private PlatformUserDAO platformUserDAO;

    @Override
    public PlatformUser getPlatformUserByUsername(String username) {
        if(StringUtils.isEmpty(username)){
            throw new NullParameterException("username");
        }
        return platformUserDAO.selectByUsername(username);
    }

    @Override
    public PlatformUser getLoginUserByUsername(String username) {
        if(StringUtils.isEmpty(username)){
            throw new NullParameterException("username");
        }
        return platformUserDAO.selectLoginUserByUsername(username);
    }

}
