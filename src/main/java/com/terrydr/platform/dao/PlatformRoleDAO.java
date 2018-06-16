package com.terrydr.platform.dao;

import com.terrydr.common.dao.EntityDAO;
import com.terrydr.platform.domain.PlatformRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlatformRoleDAO extends EntityDAO<PlatformRole> {

    /**
     * 根据参数查询Role
     * @param params
     * @return
     */
    List<PlatformRole> selectRolesByParams(Map<String, Object> params);

    /**
     * 查询所有status=1的roleName和roleId
     * @return
     */
    List<PlatformRole> selectAllRoleIdAndDesc();

    long selectCountByParams(Map<String, Object> params);
}