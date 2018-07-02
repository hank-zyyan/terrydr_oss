package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeReport;

public interface EyeReportDAO {
    int deleteByPrimaryKey(Integer reportId);

    int insert(EyeReport record);

    int insertSelective(EyeReport record);

    EyeReport selectByPrimaryKey(Integer reportId);

    int updateByPrimaryKeySelective(EyeReport record);

    int updateByPrimaryKey(EyeReport record);
}