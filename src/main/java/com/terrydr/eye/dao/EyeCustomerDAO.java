package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeCustomer;

public interface EyeCustomerDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(EyeCustomer record);

    int insertSelective(EyeCustomer record);

    EyeCustomer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EyeCustomer record);

    int updateByPrimaryKey(EyeCustomer record);
}