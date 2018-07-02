package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeGeneralExam;

public interface EyeGeneralExamDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(EyeGeneralExam record);

    int insertSelective(EyeGeneralExam record);

    EyeGeneralExam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EyeGeneralExam record);

    int updateByPrimaryKey(EyeGeneralExam record);
}