package com.terrydr.eye.domain;

import java.util.Date;

public class EyeVisionExam {
    private Integer id;

    private String encryptId;

    private Integer encounterId;

    private String encounterEncryptId;

    private String collectFile;

    private Integer lDiopter;

    private Integer rDiopter;

    private Integer hStrabismus;

    private Integer vStrabismus;

    private String redFlexImg;

    private String hirschbergImg;

    private Integer status;

    private String cover;

    private String remark;

    private String note;

    private Date createTime;

    private Date lastUpdateTime;

    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEncryptId() {
        return encryptId;
    }

    public void setEncryptId(String encryptId) {
        this.encryptId = encryptId == null ? null : encryptId.trim();
    }

    public Integer getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(Integer encounterId) {
        this.encounterId = encounterId;
    }

    public String getEncounterEncryptId() {
        return encounterEncryptId;
    }

    public void setEncounterEncryptId(String encounterEncryptId) {
        this.encounterEncryptId = encounterEncryptId == null ? null : encounterEncryptId.trim();
    }

    public String getCollectFile() {
        return collectFile;
    }

    public void setCollectFile(String collectFile) {
        this.collectFile = collectFile == null ? null : collectFile.trim();
    }

    public Integer getlDiopter() {
        return lDiopter;
    }

    public void setlDiopter(Integer lDiopter) {
        this.lDiopter = lDiopter;
    }

    public Integer getrDiopter() {
        return rDiopter;
    }

    public void setrDiopter(Integer rDiopter) {
        this.rDiopter = rDiopter;
    }

    public Integer gethStrabismus() {
        return hStrabismus;
    }

    public void sethStrabismus(Integer hStrabismus) {
        this.hStrabismus = hStrabismus;
    }

    public Integer getvStrabismus() {
        return vStrabismus;
    }

    public void setvStrabismus(Integer vStrabismus) {
        this.vStrabismus = vStrabismus;
    }

    public String getRedFlexImg() {
        return redFlexImg;
    }

    public void setRedFlexImg(String redFlexImg) {
        this.redFlexImg = redFlexImg == null ? null : redFlexImg.trim();
    }

    public String getHirschbergImg() {
        return hirschbergImg;
    }

    public void setHirschbergImg(String hirschbergImg) {
        this.hirschbergImg = hirschbergImg == null ? null : hirschbergImg.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}