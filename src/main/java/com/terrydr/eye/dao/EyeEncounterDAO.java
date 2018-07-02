package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeEncounter;

public interface EyeEncounterDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(EyeEncounter record);

    int insertSelective(EyeEncounter record);

    EyeEncounter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EyeEncounter record);

    int updateByPrimaryKey(EyeEncounter record);
}