package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeOptometry;

public interface EyeOptometryDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(EyeOptometry record);

    int insertSelective(EyeOptometry record);

    EyeOptometry selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EyeOptometry record);

    int updateByPrimaryKey(EyeOptometry record);
}