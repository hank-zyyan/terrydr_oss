package com.terrydr.platform.dao;

import com.terrydr.common.dao.EntityDAO;
import com.terrydr.platform.domain.PlatformUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlatformUserDAO extends EntityDAO<PlatformUser> {

    PlatformUser selectByUsername(String username);


    PlatformUser selectLoginUserByUsername(String username);

    List<PlatformUser> selectUsersByParams(Map<String, Object> params);

    long selectCountByParams(Map<String, Object> params);

    int updateUserStatus(@Param("id") Integer id, @Param("status")Integer status);

    int updateUsersStatus(@Param("ids") Integer[] ids, @Param("status")Integer status);
}