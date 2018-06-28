package com.terrydr.platform.domain;

import com.terrydr.common.domain.OSSObject;

import java.util.Date;

public class PlatformLog extends OSSObject {

    private String params;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.log_id
     *
     * @mbg.generated
     */
    private Integer logId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.scope_name
     *
     * @mbg.generated
     */
    private String scopeName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.scope
     *
     * @mbg.generated
     */
    private Integer scope;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.date_loged
     *
     * @mbg.generated
     */
    private Date dateLoged;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.method_name
     *
     * @mbg.generated
     */
    private String methodName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.data_id
     *
     * @mbg.generated
     */
    private String dataId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.type
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.user
     *
     * @mbg.generated
     */
    private Integer user;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.user_account
     *
     * @mbg.generated
     */
    private String userAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.ip
     *
     * @mbg.generated
     */
    private String ip;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.operation_desc
     *
     * @mbg.generated
     */
    private String operationDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_operatation_log.millions_taken
     *
     * @mbg.generated
     */
    private Long millionsTaken;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.log_id
     *
     * @return the value of t_sys_operatation_log.log_id
     *
     * @mbg.generated
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.log_id
     *
     * @param logId the value for t_sys_operatation_log.log_id
     *
     * @mbg.generated
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.scope_name
     *
     * @return the value of t_sys_operatation_log.scope_name
     *
     * @mbg.generated
     */
    public String getScopeName() {
        return scopeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.scope_name
     *
     * @param scopeName the value for t_sys_operatation_log.scope_name
     *
     * @mbg.generated
     */
    public void setScopeName(String scopeName) {
        this.scopeName = scopeName == null ? null : scopeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.scope
     *
     * @return the value of t_sys_operatation_log.scope
     *
     * @mbg.generated
     */
    public Integer getScope() {
        return scope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.scope
     *
     * @param scope the value for t_sys_operatation_log.scope
     *
     * @mbg.generated
     */
    public void setScope(Integer scope) {
        this.scope = scope;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.date_loged
     *
     * @return the value of t_sys_operatation_log.date_loged
     *
     * @mbg.generated
     */
    public Date getDateLoged() {
        return dateLoged;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.date_loged
     *
     * @param dateLoged the value for t_sys_operatation_log.date_loged
     *
     * @mbg.generated
     */
    public void setDateLoged(Date dateLoged) {
        this.dateLoged = dateLoged;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.method_name
     *
     * @return the value of t_sys_operatation_log.method_name
     *
     * @mbg.generated
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.method_name
     *
     * @param methodName the value for t_sys_operatation_log.method_name
     *
     * @mbg.generated
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.data_id
     *
     * @return the value of t_sys_operatation_log.data_id
     *
     * @mbg.generated
     */
    public String getDataId() {
        return dataId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.data_id
     *
     * @param dataId the value for t_sys_operatation_log.data_id
     *
     * @mbg.generated
     */
    public void setDataId(String dataId) {
        this.dataId = dataId == null ? null : dataId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.type
     *
     * @return the value of t_sys_operatation_log.type
     *
     * @mbg.generated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.type
     *
     * @param type the value for t_sys_operatation_log.type
     *
     * @mbg.generated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.user
     *
     * @return the value of t_sys_operatation_log.user
     *
     * @mbg.generated
     */
    public Integer getUser() {
        return user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.user
     *
     * @param user the value for t_sys_operatation_log.user
     *
     * @mbg.generated
     */
    public void setUser(Integer user) {
        this.user = user;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.user_name
     *
     * @return the value of t_sys_operatation_log.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.user_name
     *
     * @param userName the value for t_sys_operatation_log.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.user_account
     *
     * @return the value of t_sys_operatation_log.user_account
     *
     * @mbg.generated
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.user_account
     *
     * @param userAccount the value for t_sys_operatation_log.user_account
     *
     * @mbg.generated
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.ip
     *
     * @return the value of t_sys_operatation_log.ip
     *
     * @mbg.generated
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.ip
     *
     * @param ip the value for t_sys_operatation_log.ip
     *
     * @mbg.generated
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.operation_desc
     *
     * @return the value of t_sys_operatation_log.operation_desc
     *
     * @mbg.generated
     */
    public String getOperationDesc() {
        return operationDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.operation_desc
     *
     * @param operationDesc the value for t_sys_operatation_log.operation_desc
     *
     * @mbg.generated
     */
    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc == null ? null : operationDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_operatation_log.millions_taken
     *
     * @return the value of t_sys_operatation_log.millions_taken
     *
     * @mbg.generated
     */
    public Long getMillionsTaken() {
        return millionsTaken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_operatation_log.millions_taken
     *
     * @param millionsTaken the value for t_sys_operatation_log.millions_taken
     *
     * @mbg.generated
     */
    public void setMillionsTaken(Long millionsTaken) {
        this.millionsTaken = millionsTaken;
    }

    @Override
    public Integer getId() {
        return this.logId;
    }
}