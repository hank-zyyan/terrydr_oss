package com.terrydr.eye.dao;

import com.terrydr.common.dao.EntityDAO;
import com.terrydr.eye.domain.EyeCustomer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EyeCustomerDAO extends EntityDAO<EyeCustomer>{

    /**
     * 根据参数，查询客户
     * @param params
     * @return
     */
    List<EyeCustomer> selectCustomersByParams(Map<String, Object> params);

    /**
     * 根据参数，查询客户数量
     * @param params
     * @return
     */
    long countByParams(Map<String, Object> params);

}