package com.terrydr.eye.domain;

import java.util.Date;

public class EyeScreenInterval {
    private Integer id;

    private Boolean dmType;

    private Date dxDate;

    private String ghb;

    private String sp;

    private String screenInterval;

    private Date screenDate;

    private Integer examineId;

    private String examineEncryptId;

    private Date createTime;

    private Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDmType() {
        return dmType;
    }

    public void setDmType(Boolean dmType) {
        this.dmType = dmType;
    }

    public Date getDxDate() {
        return dxDate;
    }

    public void setDxDate(Date dxDate) {
        this.dxDate = dxDate;
    }

    public String getGhb() {
        return ghb;
    }

    public void setGhb(String ghb) {
        this.ghb = ghb == null ? null : ghb.trim();
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp == null ? null : sp.trim();
    }

    public String getScreenInterval() {
        return screenInterval;
    }

    public void setScreenInterval(String screenInterval) {
        this.screenInterval = screenInterval == null ? null : screenInterval.trim();
    }

    public Date getScreenDate() {
        return screenDate;
    }

    public void setScreenDate(Date screenDate) {
        this.screenDate = screenDate;
    }

    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    public String getExamineEncryptId() {
        return examineEncryptId;
    }

    public void setExamineEncryptId(String examineEncryptId) {
        this.examineEncryptId = examineEncryptId == null ? null : examineEncryptId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}