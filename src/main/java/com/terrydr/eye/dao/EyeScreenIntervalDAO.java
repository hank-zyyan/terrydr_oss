package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeScreenInterval;

public interface EyeScreenIntervalDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(EyeScreenInterval record);

    int insertSelective(EyeScreenInterval record);

    EyeScreenInterval selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EyeScreenInterval record);

    int updateByPrimaryKey(EyeScreenInterval record);
}