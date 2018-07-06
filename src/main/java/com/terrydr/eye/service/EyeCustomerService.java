package com.terrydr.eye.service;

import com.terrydr.eye.domain.EyeCustomer;

import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.eye.service
 * @Description: 眼科客户服务接口
 * @author: YanZhengYuan
 * @Date: 7/2/2018 5:51 PM
 * @version: 1.00
 */
public interface EyeCustomerService {

    List<EyeCustomer> getCustomersByParams(Map<String, Object> params);

    long countByParams(Map<String, Object> params);

    EyeCustomer getCustomerById(Integer id);
}
