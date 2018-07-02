package com.terrydr.eye.domain;

import java.util.Date;

public class EyeGeneralExam {
    private Integer id;

    private String encryptId;

    private Integer encounterId;

    private String encounterEncryptId;

    private String collectFile;

    private String lNv;

    private String rNv;

    private Integer lIsGlasses;

    private Integer rIsGlasses;

    private String lGlassesVision;

    private String rGlassesVision;

    private String lCva;

    private String rCva;

    private String lIntraocularPressure;

    private String rIntraocularPressure;

    private String lEyePosition;

    private String rEyePosition;

    private String lEyeMovement;

    private String rEyeMovement;

    private String lEyelids;

    private String rEyelids;

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

    public String getlNv() {
        return lNv;
    }

    public void setlNv(String lNv) {
        this.lNv = lNv == null ? null : lNv.trim();
    }

    public String getrNv() {
        return rNv;
    }

    public void setrNv(String rNv) {
        this.rNv = rNv == null ? null : rNv.trim();
    }

    public Integer getlIsGlasses() {
        return lIsGlasses;
    }

    public void setlIsGlasses(Integer lIsGlasses) {
        this.lIsGlasses = lIsGlasses;
    }

    public Integer getrIsGlasses() {
        return rIsGlasses;
    }

    public void setrIsGlasses(Integer rIsGlasses) {
        this.rIsGlasses = rIsGlasses;
    }

    public String getlGlassesVision() {
        return lGlassesVision;
    }

    public void setlGlassesVision(String lGlassesVision) {
        this.lGlassesVision = lGlassesVision == null ? null : lGlassesVision.trim();
    }

    public String getrGlassesVision() {
        return rGlassesVision;
    }

    public void setrGlassesVision(String rGlassesVision) {
        this.rGlassesVision = rGlassesVision == null ? null : rGlassesVision.trim();
    }

    public String getlCva() {
        return lCva;
    }

    public void setlCva(String lCva) {
        this.lCva = lCva == null ? null : lCva.trim();
    }

    public String getrCva() {
        return rCva;
    }

    public void setrCva(String rCva) {
        this.rCva = rCva == null ? null : rCva.trim();
    }

    public String getlIntraocularPressure() {
        return lIntraocularPressure;
    }

    public void setlIntraocularPressure(String lIntraocularPressure) {
        this.lIntraocularPressure = lIntraocularPressure == null ? null : lIntraocularPressure.trim();
    }

    public String getrIntraocularPressure() {
        return rIntraocularPressure;
    }

    public void setrIntraocularPressure(String rIntraocularPressure) {
        this.rIntraocularPressure = rIntraocularPressure == null ? null : rIntraocularPressure.trim();
    }

    public String getlEyePosition() {
        return lEyePosition;
    }

    public void setlEyePosition(String lEyePosition) {
        this.lEyePosition = lEyePosition == null ? null : lEyePosition.trim();
    }

    public String getrEyePosition() {
        return rEyePosition;
    }

    public void setrEyePosition(String rEyePosition) {
        this.rEyePosition = rEyePosition == null ? null : rEyePosition.trim();
    }

    public String getlEyeMovement() {
        return lEyeMovement;
    }

    public void setlEyeMovement(String lEyeMovement) {
        this.lEyeMovement = lEyeMovement == null ? null : lEyeMovement.trim();
    }

    public String getrEyeMovement() {
        return rEyeMovement;
    }

    public void setrEyeMovement(String rEyeMovement) {
        this.rEyeMovement = rEyeMovement == null ? null : rEyeMovement.trim();
    }

    public String getlEyelids() {
        return lEyelids;
    }

    public void setlEyelids(String lEyelids) {
        this.lEyelids = lEyelids == null ? null : lEyelids.trim();
    }

    public String getrEyelids() {
        return rEyelids;
    }

    public void setrEyelids(String rEyelids) {
        this.rEyelids = rEyelids == null ? null : rEyelids.trim();
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