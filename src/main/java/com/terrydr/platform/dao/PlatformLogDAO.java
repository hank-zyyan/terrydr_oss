package com.terrydr.platform.dao;

import com.terrydr.common.dao.EntityDAO;
import com.terrydr.platform.domain.PlatformLog;

import java.util.List;
import java.util.Map;

public interface PlatformLogDAO extends EntityDAO<PlatformLog> {

    /**
     * 根据参数，查询logs
     * @param params
     * @return
     */
    List<PlatformLog> selectLogsByParams(Map<String, Object> params);

    /**
     * 根据参数，查询log数量
     * @param params
     * @return
     */
    long selectCountByParams(Map<String, Object> params);
}