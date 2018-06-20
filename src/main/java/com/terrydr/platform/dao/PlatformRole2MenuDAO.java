package com.terrydr.platform.dao;

import com.terrydr.common.dao.EntityDAO;
import com.terrydr.platform.domain.PlatformRole2Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformRole2MenuDAO extends EntityDAO<PlatformRole2Menu> {

    List<Integer> getMenuIdsByRoleId(Integer roleId);

    int deleteByRoleId(Integer roleId);
}