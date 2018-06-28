package com.terrydr.platform.domain;

import com.terrydr.common.domain.OSSObject;

import java.util.Date;

public class PlatformUser extends OSSObject {

    @Override
    public String toString() {
        return "PlatformUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private String roleDescribe;

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.USER_NAME
     *
     * @mbg.generated
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.USER_PWD
     *
     * @mbg.generated
     */
    private String userPwd;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.USER_TEL
     *
     * @mbg.generated
     */
    private String userTel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.USER_EMAIL
     *
     * @mbg.generated
     */
    private String userEmail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.USER_REAL_NAME
     *
     * @mbg.generated
     */
    private String userRealName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.REMARK
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.CREATE_USER
     *
     * @mbg.generated
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.CREATE_TIME
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.STATUS
     *
     * @mbg.generated
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.ID
     *
     * @return the value of t_sys_user.ID
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.ID
     *
     * @param id the value for t_sys_user.ID
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.USER_NAME
     *
     * @return the value of t_sys_user.USER_NAME
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.USER_NAME
     *
     * @param userName the value for t_sys_user.USER_NAME
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.USER_PWD
     *
     * @return the value of t_sys_user.USER_PWD
     *
     * @mbg.generated
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.USER_PWD
     *
     * @param userPwd the value for t_sys_user.USER_PWD
     *
     * @mbg.generated
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.USER_TEL
     *
     * @return the value of t_sys_user.USER_TEL
     *
     * @mbg.generated
     */
    public String getUserTel() {
        return userTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.USER_TEL
     *
     * @param userTel the value for t_sys_user.USER_TEL
     *
     * @mbg.generated
     */
    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.USER_EMAIL
     *
     * @return the value of t_sys_user.USER_EMAIL
     *
     * @mbg.generated
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.USER_EMAIL
     *
     * @param userEmail the value for t_sys_user.USER_EMAIL
     *
     * @mbg.generated
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.USER_REAL_NAME
     *
     * @return the value of t_sys_user.USER_REAL_NAME
     *
     * @mbg.generated
     */
    public String getUserRealName() {
        return userRealName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.USER_REAL_NAME
     *
     * @param userRealName the value for t_sys_user.USER_REAL_NAME
     *
     * @mbg.generated
     */
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.REMARK
     *
     * @return the value of t_sys_user.REMARK
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.REMARK
     *
     * @param remark the value for t_sys_user.REMARK
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.CREATE_USER
     *
     * @return the value of t_sys_user.CREATE_USER
     *
     * @mbg.generated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.CREATE_USER
     *
     * @param createUser the value for t_sys_user.CREATE_USER
     *
     * @mbg.generated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.CREATE_TIME
     *
     * @return the value of t_sys_user.CREATE_TIME
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.CREATE_TIME
     *
     * @param createTime the value for t_sys_user.CREATE_TIME
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.STATUS
     *
     * @return the value of t_sys_user.STATUS
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.STATUS
     *
     * @param status the value for t_sys_user.STATUS
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}