package com.terrydr.platform.service.impl;

import com.terrydr.common.exception.service.ErrorParameterException;
import com.terrydr.common.exception.service.NullParameterException;
import com.terrydr.common.utils.MD5;
import com.terrydr.common.utils.OSSContext;
import com.terrydr.platform.dao.PlatformRoleDAO;
import com.terrydr.platform.dao.PlatformUserDAO;
import com.terrydr.platform.domain.PlatformUser;
import com.terrydr.platform.service.PlatformUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr.platform.service.impl
 * @Description: ${TODO}
 * @author: YanZhengYuan
 * @Date: 6/12/2018 8:42 PM
 * @version: 1.00
 */
@Service
public class PlatformUserServiceImpl implements PlatformUserService{

    @Resource
    private PlatformUserDAO platformUserDAO;

    @Resource
    private PlatformRoleDAO platformRoleDAO;

    /**
     * @Description: 根据用户名，查询用户
     * @param username
     * @return PlatformUser
     * @throws
     * @author YanZhengYaun
     * @date 6/12/2018 8:39 PM
     */
    @Override
    public PlatformUser getPlatformUserByUsername(String username) {
        if(StringUtils.isEmpty(username)){
            throw new NullParameterException("username");
        }
        return platformUserDAO.selectByUsername(username);
    }

    /**
     * @Description: 根据用户名，查询用户(登陆用)
     * @param username
     * @return PlatformUser
     * @throws
     * @author YanZhengYaun
     * @date 6/12/2018 8:39 PM
     */
    @Override
    public PlatformUser getLoginUserByUsername(String username) {
        if(StringUtils.isEmpty(username)){
            throw new NullParameterException("username");
        }
        return platformUserDAO.selectLoginUserByUsername(username);
    }

    /**
    * @Description: 获取所有用户
    * @return List<PlatformUser>
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 3:04 PM
    */
    @Override
    public List<PlatformUser> getAllUsers() {
        return platformUserDAO.selectUsersByParams(null);
    }

    /**
    * @Description: 通过参数，查询用户
    * @param params
    * @return List<PlatformUser>
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 4:29 PM
    */
    @Override
    public List<PlatformUser> getUsersByParams(Map<String, Object> params) {
        if(params == null){
            throw new NullParameterException("params");
        }
        params.put("needRole", true);
        return platformUserDAO.selectUsersByParams(params);
    }

    /**
    * @Description: 查询全部用户数
    * @return long
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 4:29 PM
    */
    @Override
    public long countAll() {
        return platformUserDAO.selectCountByParams(null);
    }

    /**
    * @Description: 通过参数，查询用户数
    * @param params
    * @return long
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 4:30 PM
    */
    @Override
    public long countByParams(Map<String, Object> params) {
        return platformUserDAO.selectCountByParams(params);
    }

    /**
     * 是否存在用户名为userName的用户，存在返回true
     * @param userName
     * @return
     */
    @Override
    public boolean exist(String userName) {
        if(StringUtils.isEmpty(userName)){
            throw new NullParameterException("userName");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("userName", userName);
        return countByParams(params) > 0;
    }


    /**
     * @Description: 禁用用户
     * @param id
     * @return int
     * @throws
     * @author YanZhengYaun
     * @date 6/15/2018 10:50 AM
     */
    @Override
    @Transactional
    public int forbidUser(Integer id) {
        if(id == null){
            throw new NullParameterException("id");
        }
        return platformUserDAO.updateUserStatus(id, 0);
    }

    /**
    * @Description: 批量禁用用户
    * @param ids
    * @return int
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 5:09 PM
    */
    @Override
    @Transactional
    public int forbidUsers(Integer... ids) {
        if(ids == null){
            throw new NullParameterException("ids");
        }
        if(ids.length <= 0){
            throw new ErrorParameterException("ids");
        }
        return platformUserDAO.updateUsersStatus(ids, 0);
    }

    /**
     * @Description: 启用用户
     * @param id
     * @return int
     * @throws
     * @author YanZhengYaun
     * @date 6/15/2018 10:50 AM
     */
    @Override
    @Transactional
    public int startUser(Integer id) {
        if(id == null){
            throw new NullParameterException("id");
        }
        return platformUserDAO.updateUserStatus(id, 1);
    }

    /**
    * @Description: 批量启用用户
    * @param ids
    * @return int
    * @throws
    * @author YanZhengYaun
    * @date 6/15/2018 5:10 PM
    */
    @Override
    @Transactional
    public int startUsers(Integer... ids) {
        if(ids == null){
            throw new NullParameterException("ids");
        }
        if(ids.length <= 0){
            throw new ErrorParameterException("ids");
        }
        return platformUserDAO.updateUsersStatus(ids, 1);
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @Override
    public int saveUser(PlatformUser user) {
        if(StringUtils.isEmpty(user.getUserName())){
            throw new NullParameterException("userName");
        }
        if(user.getUserName().length() < 2 || exist(user.getUserName())){
            throw new ErrorParameterException("userName");
        }
        if(StringUtils.isEmpty(user.getUserRealName())){
            throw new NullParameterException("realName");
        }
        if(user.getUserPwd() == null){
            throw new NullParameterException("pwd");
        }
        if(user.getUserPwd().length() < 6){
            throw new ErrorParameterException("pwd");
        }
        if(StringUtils.isEmpty(user.getUserTel())){
            throw new NullParameterException("tel");
        }
        if(StringUtils.isEmpty(user.getUserEmail())){
            throw new ErrorParameterException("email");
        }
        if(StringUtils.isEmpty(user.getStatus())){
            user.setStatus("1");
        }
        if(user.getRoleId() == null){
            throw new NullParameterException("roleId");
        }
        Map<String, Object> param = new HashMap<>();
        param.put("roleId", user.getRoleId());
        if(platformRoleDAO.selectCountByParams(param) == 0){
            throw new ErrorParameterException("roleId");
        }
        String hashedPWD = MD5.getMD5(user.getUserPwd());
        user.setUserPwd(hashedPWD);
        user.setCreateUser(OSSContext.getCurrentUser().getUserName());
        return platformUserDAO.insertSelective(user);
    }

    /**
     * 通过id，获取user
     * @param id
     * @return
     */
    @Override
    public PlatformUser getUserById(Integer id) {
        if(id == null){
            throw new NullParameterException("id");
        }
        return platformUserDAO.selectByPrimaryKey(id);
    }

    @Override
    public PlatformUser getUserAndRoleNameById(Integer id) {
        if(id == null){
            throw new NullParameterException("id");
        }
        return platformUserDAO.selectUserAndRoleNameById(id);
    }

    @Override
    public int updateUser(PlatformUser user) {
        if(user.getId() == null){
            throw new NullParameterException("id");
        }
        if(StringUtils.isEmpty(user.getUserRealName())){
            throw new NullParameterException("name");
        }
        if(StringUtils.isEmpty(user.getUserTel())){
            throw new NullParameterException("tel");
        }
        if(StringUtils.isEmpty(user.getUserEmail())){
            throw new NullParameterException("email");
        }
        if(user.getRoleId() == null){
            throw new NullParameterException("roleId");
        }
        Map<String, Object> param = new HashMap<>();
        param.put("roleId", user.getRoleId());
        if(platformRoleDAO.selectCountByParams(param) == 0){
            throw new ErrorParameterException("roleId");
        }
        user.setCreateUser(null);
        user.setUserPwd(null);
        user.setStatus(null);
        user.setCreateTime(null);
        user.setRemark(null);
        user.setUserName(null);
        return platformUserDAO.updateByPrimaryKeySelective(user);
    }

    @Override
    public int adminResetPwd(Integer id, String pwd) {
        if(id == null){
            throw new NullParameterException("id");
        }
        if(StringUtils.isEmpty(pwd)){
            throw new NullParameterException("pwd");
        }
        PlatformUser user = new PlatformUser();
        user.setId(id);
        user.setUserPwd(MD5.getMD5(pwd));
        return platformUserDAO.updateByPrimaryKeySelective(user);
    }

}
