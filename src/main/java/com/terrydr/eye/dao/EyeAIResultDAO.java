package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeAIResult;
import com.terrydr.eye.domain.EyeAIResultKey;

public interface EyeAIResultDAO {
    int deleteByPrimaryKey(EyeAIResultKey key);

    int insert(EyeAIResult record);

    int insertSelective(EyeAIResult record);

    EyeAIResult selectByPrimaryKey(EyeAIResultKey key);

    int updateByPrimaryKeySelective(EyeAIResult record);

    int updateByPrimaryKey(EyeAIResult record);
}