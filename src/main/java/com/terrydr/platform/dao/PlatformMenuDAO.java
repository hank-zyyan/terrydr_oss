package com.terrydr.platform.dao;

import com.terrydr.common.dao.EntityDAO;
import com.terrydr.platform.domain.PlatformMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlatformMenuDAO extends EntityDAO<PlatformMenu> {

    List<PlatformMenu> selectLoginMenuByRoleId(Integer roleId);

    List<PlatformMenu> selectMenusByParams(Map<String, Object> params);

    String selectMenuNameByMenuId(Integer id);

    Integer selectMenuLevelByMenuId(Integer id);

    int updateMenuStatus(@Param("id") Integer id, @Param("status")Integer status);
}