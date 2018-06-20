package com.terrydr.platform.service.impl;

import com.terrydr.common.exception.service.ErrorParameterException;
import com.terrydr.common.exception.service.NullParameterException;
import com.terrydr.common.utils.OSSContext;
import com.terrydr.platform.dao.PlatformRole2MenuDAO;
import com.terrydr.platform.dao.PlatformRoleDAO;
import com.terrydr.platform.domain.PlatformRole;
import com.terrydr.platform.domain.PlatformRole2Menu;
import com.terrydr.platform.service.PlatformRoleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.service.impl
 * @Description: 平台角色服务实现类
 * @author: YanZhengYuan
 * @Date: 2018/6/16 12:08
 * @version: 1.00
 */
@Service
public class PlatformRoleServiceImpl implements PlatformRoleService {

    private static final Log logger = LogFactory.getLog(PlatformRoleServiceImpl.class);

    @Resource
    private PlatformRoleDAO platformRoleDAO;

    @Resource
    private PlatformRole2MenuDAO platformRole2MenuDAO;

    /**
     * 获取正在启用的所有role的id和desc
     * @return
     */
    @Override
    public List<PlatformRole> getAllRoleIdAndDesc() {
        return platformRoleDAO.selectAllRoleIdAndDesc();
    }

    /**
     * 获取所有的权限数据
     * @return
     */
    @Override
    public List<PlatformRole> getAllRoles() {
        return platformRoleDAO.selectRolesByParams(null);
    }


    /**
     * 保存角色，并增加角色管理的菜单
     * @param roleToSave
     * @param menuIdsToAccess
     */
    @Override
    @Transactional
    public void saveRoleWithAccessableMenus(PlatformRole roleToSave, int... menuIdsToAccess) {
        logger.debug(menuIdsToAccess);
        roleToSave.setCreateTime(null);
        roleToSave.setStatus(null);
        if(StringUtils.isEmpty(roleToSave.getRoleName())){
            throw new NullParameterException("roleName");
        }
        if(StringUtils.isEmpty(roleToSave.getRoleDescribe())){
            throw new NullParameterException("roleDescribe");
        }
        if(menuIdsToAccess == null){
            throw new NullParameterException("ids");
        }
        roleToSave.setCreateUser(OSSContext.getCurrentUser().getUserName());
        platformRoleDAO.insertSelective(roleToSave);
        Integer roleId = roleToSave.getId();

        Assert.notNull(roleId, "新插入的角色ID，不可能为空");

        //保存角色和菜单关系
        for(int mId : menuIdsToAccess){
            if(mId == -1){ //根节点为虚拟节点，id=-1，去除
                continue;
            }
            PlatformRole2Menu r2m = new PlatformRole2Menu();
            r2m.setMenuId(mId);
            r2m.setRoleId(roleId);
            platformRole2MenuDAO.insert(r2m);
        }
    }

    @Override
    public void updateRoleWithAccessableMenus(PlatformRole roleToUpdate, int... menuIdsToAccess) {
        roleToUpdate.setCreateTime(null);
        roleToUpdate.setStatus(null);
        roleToUpdate.setCreateUser(null);
        if(roleToUpdate.getId() == null){
            throw new NullParameterException("id");
        }
        if(StringUtils.isEmpty(roleToUpdate.getRoleName())){
            throw new NullParameterException("roleName");
        }
        if(StringUtils.isEmpty(roleToUpdate.getRoleDescribe())){
            throw new NullParameterException("roleDescribe");
        }
        if(menuIdsToAccess == null){
            throw new NullParameterException("ids");
        }

        //1.更新角色，并获取roleId
        platformRoleDAO.updateByPrimaryKeySelective(roleToUpdate);
        Integer roleId = roleToUpdate.getId();

        Assert.notNull(roleId, "更新的角色ID，不可能为空");

        //2.删除角色和原来菜单关系
        if(menuIdsToAccess.length > 1)
            platformRole2MenuDAO.deleteByRoleId(roleId);

        //保存角色和菜单关系
        for(int mId : menuIdsToAccess){
            if(mId == -1){ //根节点为虚拟节点，id=-1，去除
                continue;
            }
            PlatformRole2Menu r2m = new PlatformRole2Menu();
            r2m.setMenuId(mId);
            r2m.setRoleId(roleId);
            platformRole2MenuDAO.insert(r2m);
        }
    }

    /**
     * 根据角色ID，查询角色
     * @param id
     * @return
     */
    @Override
    public PlatformRole getRoleById(Integer id) {
        if(id == null){
            throw new NullParameterException("id");
        }
        return platformRoleDAO.selectByPrimaryKey(id);
    }
}
