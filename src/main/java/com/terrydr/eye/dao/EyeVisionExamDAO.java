package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeVisionExam;

public interface EyeVisionExamDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(EyeVisionExam record);

    int insertSelective(EyeVisionExam record);

    EyeVisionExam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EyeVisionExam record);

    int updateByPrimaryKey(EyeVisionExam record);
}