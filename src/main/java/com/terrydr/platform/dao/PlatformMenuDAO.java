package com.terrydr.platform.dao;

import com.terrydr.common.dao.EntityDAO;
import com.terrydr.platform.domain.PlatformMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatformMenuDAO extends EntityDAO<PlatformMenu> {

    List<PlatformMenu> selectLoginMenuByRoleId(Integer roleId);

}