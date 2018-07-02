package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeAITask;

public interface EyeAITaskDAO {
    int deleteByPrimaryKey(String id);

    int insert(EyeAITask record);

    int insertSelective(EyeAITask record);

    EyeAITask selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EyeAITask record);

    int updateByPrimaryKey(EyeAITask record);
}