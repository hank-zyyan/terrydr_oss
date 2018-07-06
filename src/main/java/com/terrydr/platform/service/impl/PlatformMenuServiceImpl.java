package com.terrydr.platform.service.impl;

import com.terrydr.common.exception.service.ErrorParameterException;
import com.terrydr.common.exception.service.NullParameterException;
import com.terrydr.common.exception.service.ObjectNotFoundException;
import com.terrydr.common.utils.Constant;
import com.terrydr.common.utils.OSSContext;
import com.terrydr.platform.dao.PlatformMenuDAO;
import com.terrydr.platform.dao.PlatformRole2MenuDAO;
import com.terrydr.platform.domain.JSTree;
import com.terrydr.platform.domain.MenuTree;
import com.terrydr.platform.domain.PlatformMenu;
import com.terrydr.platform.service.PlatformMenuService;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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

    @Resource
    private PlatformRole2MenuDAO platformRole2MenuDAO;

    /**
    * @Description: 获取当前用户能够访问的菜单
    * @return List<MenuTree>
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 10:52 AM
    */
    @Override
    @Cacheable(keyGenerator= "currentUserRoleIdKeyGen")
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
                menuList.add(new MenuTree(menu));
                menusMap.put(pId, menuList);
            }else{
                menusMap.get(pId).add(new MenuTree(menu));
            }
        }

        //4.生成Menu Tree
        List<MenuTree> menusTree;
        menusTree = MenuTree.buildTreesFromDB(0, menusMap);
        return menusTree;
    }

    @Override
    public JSTree getEnableMenusTree() {
        //1.获取可用的菜单列表
        List<PlatformMenu> menus = platformMenuDAO.selectEnableJsTreeMenu();

        //2.将菜单以parentId归类
        Map<Integer, List<JSTree>> menusMap = new HashMap<>();
        for (PlatformMenu menu : menus){
            Integer pId = menu.getParentMenuId();
            if(menusMap.get(pId) == null){
                List<JSTree> menuList = new ArrayList<>();
                menuList.add(new JSTree(menu));
                menusMap.put(pId, menuList);
            }else{
                menusMap.get(pId).add(new JSTree(menu));
            }
        }

        //3.创造一个root
        JSTree root = new JSTree();
        root.setId(-1);
        root.setParentId(0);
        root.setChildren(new ArrayList<>());
        root.setText("顶级节点");
        Map<String, Object> state = new HashMap<>(16);
        state.put("opened", true);
        root.setState(state);

        //4.生成一个tree
        MenuTree.buildTreeFromDB(0, menusMap, root);
        return root;
    }

    @Override
    @Cacheable
    public JSTree getEnableMenusTreeByRoleId(Integer roleId) {
        //1.获取可用的菜单列表
        List<PlatformMenu> menus = platformMenuDAO.selectEnableJsTreeMenu();

        //2.获取roleId已关联的菜单id
        List<Integer> menuIds = platformRole2MenuDAO.getMenuIdsByRoleId(roleId);

        //2.将菜单以parentId归类
        Map<Integer, List<JSTree>> menusMap = new HashMap<>();
        for (PlatformMenu menu : menus){
            Integer pId = menu.getParentMenuId();
            JSTree jsTree = new JSTree(menu);
            if(menu.getMenuLevel() == 3 && menuIds != null && menuIds.contains(menu.getId())){  //已关联
                Map<String, Object> state = new HashMap<>(16);
                state.put("selected", true);
                jsTree.setState(state);
            }
            if(menusMap.get(pId) == null){
                List<JSTree> menuList = new ArrayList<>();
                menuList.add(jsTree);
                menusMap.put(pId, menuList);
            }else{
                menusMap.get(pId).add(jsTree);
            }
        }

        //3.创造一个root
        JSTree root = new JSTree();
        root.setId(-1);
        root.setParentId(0);
        root.setChildren(new ArrayList<>());
        root.setText("顶级节点");
        Map<String, Object> state = new HashMap<>(16);
        state.put("opened", true);
        root.setState(state);

        //4.生成一个tree
        MenuTree.buildTreeFromDB(0, menusMap, root);
        return root;
    }

    /**
    * @Description: 获取所有菜单，用于菜单管理
    * @return List<PlatformMenu>
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 10:51 AM
    */
    @Override
    public List<PlatformMenu> getAllMenus() {
        return platformMenuDAO.selectMenusByParams(null);
    }

    /**
    * @Description: 通过菜单ID，获取菜单名(缓存)
    * @param id
    * @return String
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 10:51 AM
    */
    @Override
    @Cacheable(key = "#id", condition = "#id != null ")
    public String getMenuNameById(Integer id) {
        if(id == null){
            throw new NullParameterException("id");
        }
        return platformMenuDAO.selectMenuNameByMenuId(id);
    }

    /**
    * @Description: 添加菜单
    * @param menu
    * @return int
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 10:50 AM
    */
    @Override
    @Transactional("platformTransactionManager")
    @CacheEvict(allEntries=true)
    public int saveMenu(PlatformMenu menu) {
        if(StringUtils.isEmpty(menu.getMenuName())){
            throw new NullParameterException("menu");
        }
        if(menu.getParentMenuId() == null){
            throw new NullParameterException("menu");
        }
        if(menu.getSort() == null){
            throw new NullParameterException("menu");
        }
        if(menu.getSort() > 99){
            throw new ErrorParameterException("menu");
        }
        if(StringUtils.isEmpty(menu.getStatus())){
            menu.setStatus("1");
        }
        if(menu.getParentMenuId() == Constant.Menu.ROOT_PARENT_ID){
            menu.setMenuLevel(Constant.Menu.FIRST);
        }else{
            menu.setMenuLevel(platformMenuDAO.selectMenuLevelByMenuId(menu.getParentMenuId()));
        }
        return platformMenuDAO.insertSelective(menu);
    }

    /**
    * @Description: 禁用菜单
    * @param id
    * @return int
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 10:50 AM
    */
    @Override
    @Transactional("platformTransactionManager")
    @CacheEvict(allEntries=true)
    public int forbidMenu(Integer id) {
        if(id == null){
            throw new NullParameterException("id");
        }
        return platformMenuDAO.updateMenuStatus(id, 0);
    }

    /**
     * @Description: 启用菜单
     * @param id
     * @return int
     * @throws
     * @author YanZhengYaun
     * @date 6/15/2018 10:50 AM
     */
    @Override
    @Transactional("platformTransactionManager")
    @CacheEvict(allEntries=true)
    public int startMenu(Integer id) {
        if(id == null){
            throw new NullParameterException("id");
        }
        return platformMenuDAO.updateMenuStatus(id, 1);
    }

    /**
    * @Description: 根据主键获取菜单
    * @param id
    * @return PlatformMenu
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 11:29 AM
    */
    @Override
    public PlatformMenu getMenuById(Integer id) {
        if(id == null){
            throw new NullParameterException("id");
        }
        PlatformMenu menu = platformMenuDAO.selectByPrimaryKey(id);

        if(menu == null){
            throw new ObjectNotFoundException("menu");
        }

        return menu;
    }

    /**
    * @Description: 更新菜单
    * @param menu
    * @return int
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 12:21 PM
    */
    @Override
    @CacheEvict(allEntries=true)
    public int updateMenu(PlatformMenu menu) {
        if(menu.getId() == null){
            throw new NullParameterException("menu");
        }
        if(StringUtils.isEmpty(menu.getMenuName())){
            throw new NullParameterException("menu");
        }
        if(menu.getParentMenuId() == null){
            throw new NullParameterException("menu");
        }
        if(menu.getSort() == null){
            throw new NullParameterException("menu");
        }
        if(menu.getSort() > 99){
            throw new ErrorParameterException("menu");
        }
        menu.setMenuLevel(null);
        menu.setStatus(null);
        menu.setCreateTime(null);
        menu.setParentMenuId(null);
        return platformMenuDAO.updateByPrimaryKeySelective(menu);
    }
}
