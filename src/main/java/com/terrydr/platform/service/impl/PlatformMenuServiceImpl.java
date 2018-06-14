package com.terrydr.platform.service.impl;

import com.terrydr.common.utils.OSSContext;
import com.terrydr.platform.dao.PlatformMenuDAO;
import com.terrydr.platform.domain.MenuTree;
import com.terrydr.platform.domain.PlatformMenu;
import com.terrydr.platform.service.PlatformMenuService;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.service.impl
 * @Description: 平台菜单服务实现
 * @author: YanZhengYuan
 * @Date: 6/13/2018 2:30 PM
 * @version: 1.00
 */
@Service
@CacheConfig(cacheNames = "menu")
public class PlatformMenuServiceImpl implements PlatformMenuService{

    @Resource
    private PlatformMenuDAO platformMenuDAO;

    @Override
    @Cacheable(keyGenerator="platformMenuKeyGen")
    public List<MenuTree> getUserMenu() {
        //1.验证是否认证
        if(!OSSContext.isAuthenticated()){
            throw new UnauthenticatedException("请先登陆");
        }

        //2.获取当前用户，并查询该用户菜单
        List<PlatformMenu> menus = platformMenuDAO.selectLoginMenuByRoleId(OSSContext.getCurrentUser().getRoleId());

        //3.将菜单以parentId归类
        Map<Integer, List<MenuTree>> menusMap = new HashMap<>();
        for (PlatformMenu menu : menus){
            Integer pId = menu.getParentMenuId();
            if(menusMap.get(pId) == null){
                List<MenuTree> menuList = new ArrayList<>();
                menuList.add(new MenuTree((menu)));
                menusMap.put(pId, menuList);
            }else{
                menusMap.get(pId).add(new MenuTree((menu)));
            }
        }

        //4.生成Menu Tree
        List<MenuTree> menusTree;
        menusTree = MenuTree.buildTreesFromDB(0, menusMap);
        return menusTree;
    }
}
