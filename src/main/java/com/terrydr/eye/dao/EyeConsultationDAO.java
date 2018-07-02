package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeConsultation;

public interface EyeConsultationDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(EyeConsultation record);

    int insertSelective(EyeConsultation record);

    EyeConsultation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EyeConsultation record);

    int updateByPrimaryKey(EyeConsultation record);
}