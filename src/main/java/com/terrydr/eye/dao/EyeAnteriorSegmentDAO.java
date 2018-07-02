package com.terrydr.eye.dao;

import com.terrydr.eye.domain.EyeAnteriorSegment;

public interface EyeAnteriorSegmentDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(EyeAnteriorSegment record);

    int insertSelective(EyeAnteriorSegment record);

    EyeAnteriorSegment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EyeAnteriorSegment record);

    int updateByPrimaryKey(EyeAnteriorSegment record);
}