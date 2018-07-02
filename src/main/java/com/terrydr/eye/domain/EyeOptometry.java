package com.terrydr.eye.domain;

import java.util.Date;

public class EyeOptometry {
    private Integer id;

    private String encryptId;

    private Integer encounterId;

    private String encounterEncryptId;

    private String collectFile;

    private Integer lMydriasis;

    private Integer rMydriasis;

    private String lArSph;

    private String rArSph;

    private String lArCyl;

    private String rArCyl;

    private String lArAxial;

    private String rArAxial;

    private String lArCcvHorizontal;

    private String rArCcvHorizontal;

    private String lArCcvVerticality;

    private String rArCcvVerticality;

    private String lIoSph;

    private String rIoSph;

    private String lIoCyl;

    private String rIoCyl;

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

    public Integer getlMydriasis() {
        return lMydriasis;
    }

    public void setlMydriasis(Integer lMydriasis) {
        this.lMydriasis = lMydriasis;
    }

    public Integer getrMydriasis() {
        return rMydriasis;
    }

    public void setrMydriasis(Integer rMydriasis) {
        this.rMydriasis = rMydriasis;
    }

    public String getlArSph() {
        return lArSph;
    }

    public void setlArSph(String lArSph) {
        this.lArSph = lArSph == null ? null : lArSph.trim();
    }

    public String getrArSph() {
        return rArSph;
    }

    public void setrArSph(String rArSph) {
        this.rArSph = rArSph == null ? null : rArSph.trim();
    }

    public String getlArCyl() {
        return lArCyl;
    }

    public void setlArCyl(String lArCyl) {
        this.lArCyl = lArCyl == null ? null : lArCyl.trim();
    }

    public String getrArCyl() {
        return rArCyl;
    }

    public void setrArCyl(String rArCyl) {
        this.rArCyl = rArCyl == null ? null : rArCyl.trim();
    }

    public String getlArAxial() {
        return lArAxial;
    }

    public void setlArAxial(String lArAxial) {
        this.lArAxial = lArAxial == null ? null : lArAxial.trim();
    }

    public String getrArAxial() {
        return rArAxial;
    }

    public void setrArAxial(String rArAxial) {
        this.rArAxial = rArAxial == null ? null : rArAxial.trim();
    }

    public String getlArCcvHorizontal() {
        return lArCcvHorizontal;
    }

    public void setlArCcvHorizontal(String lArCcvHorizontal) {
        this.lArCcvHorizontal = lArCcvHorizontal == null ? null : lArCcvHorizontal.trim();
    }

    public String getrArCcvHorizontal() {
        return rArCcvHorizontal;
    }

    public void setrArCcvHorizontal(String rArCcvHorizontal) {
        this.rArCcvHorizontal = rArCcvHorizontal == null ? null : rArCcvHorizontal.trim();
    }

    public String getlArCcvVerticality() {
        return lArCcvVerticality;
    }

    public void setlArCcvVerticality(String lArCcvVerticality) {
        this.lArCcvVerticality = lArCcvVerticality == null ? null : lArCcvVerticality.trim();
    }

    public String getrArCcvVerticality() {
        return rArCcvVerticality;
    }

    public void setrArCcvVerticality(String rArCcvVerticality) {
        this.rArCcvVerticality = rArCcvVerticality == null ? null : rArCcvVerticality.trim();
    }

    public String getlIoSph() {
        return lIoSph;
    }

    public void setlIoSph(String lIoSph) {
        this.lIoSph = lIoSph == null ? null : lIoSph.trim();
    }

    public String getrIoSph() {
        return rIoSph;
    }

    public void setrIoSph(String rIoSph) {
        this.rIoSph = rIoSph == null ? null : rIoSph.trim();
    }

    public String getlIoCyl() {
        return lIoCyl;
    }

    public void setlIoCyl(String lIoCyl) {
        this.lIoCyl = lIoCyl == null ? null : lIoCyl.trim();
    }

    public String getrIoCyl() {
        return rIoCyl;
    }

    public void setrIoCyl(String rIoCyl) {
        this.rIoCyl = rIoCyl == null ? null : rIoCyl.trim();
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