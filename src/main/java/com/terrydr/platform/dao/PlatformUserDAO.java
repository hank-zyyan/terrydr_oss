package com.terrydr.platform.dao;

import com.terrydr.common.dao.EntityDAO;
import com.terrydr.platform.domain.PlatformUser;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformUserDAO extends EntityDAO<PlatformUser> {

    PlatformUser selectByUsername(String username);


    PlatformUser selectLoginUserByUsername(String username);
}