package com.terrydr.platform.service.impl;

import com.terrydr.common.exception.authenticator.UnAuthenticatedException;
import com.terrydr.common.exception.service.ErrorParameterException;
import com.terrydr.common.exception.service.NullParameterException;
import com.terrydr.common.utils.OSSContext;
import com.terrydr.platform.dao.PlatformLogDAO;
import com.terrydr.platform.domain.PlatformLog;
import com.terrydr.platform.service.PlatformLogService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.service.impl
 * @Description: 系统日志服务实现类
 * @author: YanZhengYuan
 * @Date: 2018/6/28 15:23
 * @version: 1.00
 */
@Service
public class PlatformLogServiceImpl implements PlatformLogService{

    @Resource
    private PlatformLogDAO platformLogDAO;

    /**
    * @Description: 根据参数，获取数量
    * @param params
    * @return long
    * @author YanZhengYaun
    * @date 2018/6/28 15:34
    */
    @Override
    public long countByParams(Map<String, Object> params) {
        return platformLogDAO.selectCountByParams(params);
    }

    /**
    * @Description: 根据参数，查询日志
    * @param params
    * @return List<PlatformLog>
    * @author YanZhengYaun
    * @date 2018/6/28 15:35
    */
    @Override
    public List<PlatformLog> getLogsByParams(Map<String, Object> params) {
        if(params == null){
            throw new NullParameterException("params");
        }
        return platformLogDAO.selectLogsByParams(params);
    }

    @Override
    public int saveLog(PlatformLog log) {
        if(StringUtils.isEmpty(log.getScopeName())){
            throw new NullParameterException("scopeName");
        }
        if(log.getScope() == null){
            throw new NullParameterException("scope");
        }
        if(StringUtils.isEmpty(log.getMethodName())){
            throw new NullParameterException("methodName");
        }
        if(log.getType() == 0){
            throw new NullParameterException("type");
        }
        if(StringUtils.isEmpty(log.getIp())){
            throw new NullParameterException("ip");
        }
        if(StringUtils.isEmpty(log.getOperationDesc())){
            throw new NullParameterException("desc");
        }
        if(log.getMillionsTaken() == 0){
            throw new NullParameterException("time");
        }
        if(!OSSContext.isAuthenticated()){
            throw new UnAuthenticatedException("未登录");
        }
        log.setUser(OSSContext.getCurrentUser().getId());
        log.setUserAccount(OSSContext.getCurrentUser().getUserName());
        log.setUserName(OSSContext.getCurrentUser().getUserRealName());

        return platformLogDAO.insertSelective(log);
    }
}
