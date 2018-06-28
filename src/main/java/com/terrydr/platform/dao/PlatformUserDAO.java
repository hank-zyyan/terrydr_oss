package com.terrydr.platform.dao;

import com.terrydr.common.dao.EntityDAO;
import com.terrydr.platform.domain.PlatformUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlatformUserDAO extends EntityDAO<PlatformUser> {

    /**
     * 根据username，查询user
     * @param username
     * @return
     */
    PlatformUser selectByUsername(String username);

    /**
     * 根据username，查询ID,USER_PWD,STATUS,USER_NAME,USER_REAL_NAMEROLE_ID,ROLE_NAME
     * @param username
     * @return
     */
    PlatformUser selectLoginUserByUsername(String username);

    /**
     * 根据参数，查询users
     * @param params
     * @return
     */
    List<PlatformUser> selectUsersByParams(Map<String, Object> params);

    /**
     * 根据参数，查询用户数量
     * @param params
     * @return
     */
    long selectCountByParams(Map<String, Object> params);

    /**
     * 根据id，更新status
     * @param id
     * @param status
     * @return
     */
    int updateUserStatus(@Param("id") Integer id, @Param("status")Integer status);

    /**
     * 根据ids，批量更新status
     * @param ids
     * @param status
     * @return
     */
    int updateUsersStatus(@Param("ids") Integer[] ids, @Param("status")Integer status);

    /**
     * 根据userId，获取user和roleName
     * @param id
     * @return
     */
    PlatformUser selectUserAndRoleNameById(Integer id);
}