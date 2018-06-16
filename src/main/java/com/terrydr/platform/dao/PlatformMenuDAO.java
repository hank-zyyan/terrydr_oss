package com.terrydr.platform.dao;

import com.terrydr.common.dao.EntityDAO;
import com.terrydr.platform.domain.PlatformMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlatformMenuDAO extends EntityDAO<PlatformMenu> {

    /**
     * 根据roleId，查询菜单
     * @param roleId
     * @return
     */
    List<PlatformMenu> selectLoginMenuByRoleId(Integer roleId);

    /**
     * 根据参数，查询菜单
     * @param params
     * @return
     */
    List<PlatformMenu> selectMenusByParams(Map<String, Object> params);

    /**
     * 根据id，查询菜单名
     * @param id
     * @return
     */
    String selectMenuNameByMenuId(Integer id);

    /**
     * 根据id，查询菜单level
     * @param id
     * @return
     */
    Integer selectMenuLevelByMenuId(Integer id);

    /**
     * 根据id，更新status
     * @param id
     * @param status
     * @return
     */
    int updateMenuStatus(@Param("id") Integer id, @Param("status")Integer status);
}