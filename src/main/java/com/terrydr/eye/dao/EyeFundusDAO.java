package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeFundus;

public interface EyeFundusDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(EyeFundus record);

    int insertSelective(EyeFundus record);

    EyeFundus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EyeFundus record);

    int updateByPrimaryKey(EyeFundus record);
}