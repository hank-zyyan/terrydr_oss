package com.terrydr.eye.service.impl;

import com.terrydr.common.exception.service.NullParameterException;
import com.terrydr.eye.dao.EyeCustomerDAO;
import com.terrydr.eye.domain.EyeCustomer;
import com.terrydr.eye.service.EyeCustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.eye.service.impl
 * @Description: 眼科客户服务实现类
 * @author: YanZhengYuan
 * @Date: 7/2/2018 5:53 PM
 * @version: 1.00
 */
@Service
public class EyeCustomerServiceImpl implements EyeCustomerService{

    @Resource
    private EyeCustomerDAO eyeCustomerDAO;

    /**
    * @Description: 根据参数，获得用户
    * @param params
    * @return List<EyeCustomer>
    * @author YanZhengYaun
    * @date 7/2/2018 5:59 PM
    */
    @Override
    public List<EyeCustomer> getCustomersByParams(Map<String, Object> params) {
        if(params == null){
            throw new NullParameterException("params");
        }
        return eyeCustomerDAO.selectCustomersByParams(params);
    }

    /**
    * @Description: 根据参数，获得用户数量
    * @param params
    * @return long
    * @author YanZhengYaun
    * @date 7/2/2018 6:50 PM
    */
    @Override
    public long countByParams(Map<String, Object> params) {
        if(params == null){
            throw new NullParameterException("params");
        }
        return eyeCustomerDAO.countByParams(params);
    }

    /**
    * @Description: 根据客户ID，查询客户信息
    * @param id
    * @return EyeCustomer
    * @author YanZhengYaun
    * @date 7/2/2018 8:51 PM
    */
    @Override
    public EyeCustomer getCustomerById(Integer id) {
        if(id == null){
            throw new NullParameterException("id");
        }
        return eyeCustomerDAO.selectByPrimaryKey(id);
    }
}
