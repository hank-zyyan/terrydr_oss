package com.terrydr.eye.domain;

import java.util.Date;

public class EyeAnteriorSegment {
    private Integer id;

    private String encryptId;

    private Integer encounterId;

    private String encounterEncryptId;

    private String leftImg;

    private String rightImg;

    private String leftVideo;

    private String rightVideo;

    private String collectFile;

    private Integer lMydriasis;

    private Integer rMydriasis;

    private String lConjunctiva;

    private String rConjunctiva;

    private String lCornea;

    private String rCornea;

    private String lAnteriorChamberDepth;

    private String rAnteriorChamberDepth;

    private String lAnteriorChamberStatus;

    private String rAnteriorChamberStatus;

    private String lIris;

    private String rIris;

    private Float lPupilDiameter;

    private Float rPupilDiameter;

    private String lPupilStatus;

    private String rPupilStatus;

    private Integer lPupilDirectLightReflection;

    private Integer rPupilDirectLightReflection;

    private Integer lPupilIndirectLightReflection;

    private Integer rPupilIndirectLightReflection;

    private Integer lPupilRapd;

    private Integer rPupilRapd;

    private Integer lLens;

    private Integer rLens;

    private Integer lNucleusChaosLev;

    private Integer rNucleusChaosLev;

    private Integer lIntraocularLens;

    private Integer rIntraocularLens;

    private String lVitreum;

    private String rVitreum;

    private String cover;

    private String remark;

    private Integer reportStatus;

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

    public String getLeftImg() {
        return leftImg;
    }

    public void setLeftImg(String leftImg) {
        this.leftImg = leftImg == null ? null : leftImg.trim();
    }

    public String getRightImg() {
        return rightImg;
    }

    public void setRightImg(String rightImg) {
        this.rightImg = rightImg == null ? null : rightImg.trim();
    }

    public String getLeftVideo() {
        return leftVideo;
    }

    public void setLeftVideo(String leftVideo) {
        this.leftVideo = leftVideo == null ? null : leftVideo.trim();
    }

    public String getRightVideo() {
        return rightVideo;
    }

    public void setRightVideo(String rightVideo) {
        this.rightVideo = rightVideo == null ? null : rightVideo.trim();
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

    public String getlConjunctiva() {
        return lConjunctiva;
    }

    public void setlConjunctiva(String lConjunctiva) {
        this.lConjunctiva = lConjunctiva == null ? null : lConjunctiva.trim();
    }

    public String getrConjunctiva() {
        return rConjunctiva;
    }

    public void setrConjunctiva(String rConjunctiva) {
        this.rConjunctiva = rConjunctiva == null ? null : rConjunctiva.trim();
    }

    public String getlCornea() {
        return lCornea;
    }

    public void setlCornea(String lCornea) {
        this.lCornea = lCornea == null ? null : lCornea.trim();
    }

    public String getrCornea() {
        return rCornea;
    }

    public void setrCornea(String rCornea) {
        this.rCornea = rCornea == null ? null : rCornea.trim();
    }

    public String getlAnteriorChamberDepth() {
        return lAnteriorChamberDepth;
    }

    public void setlAnteriorChamberDepth(String lAnteriorChamberDepth) {
        this.lAnteriorChamberDepth = lAnteriorChamberDepth == null ? null : lAnteriorChamberDepth.trim();
    }

    public String getrAnteriorChamberDepth() {
        return rAnteriorChamberDepth;
    }

    public void setrAnteriorChamberDepth(String rAnteriorChamberDepth) {
        this.rAnteriorChamberDepth = rAnteriorChamberDepth == null ? null : rAnteriorChamberDepth.trim();
    }

    public String getlAnteriorChamberStatus() {
        return lAnteriorChamberStatus;
    }

    public void setlAnteriorChamberStatus(String lAnteriorChamberStatus) {
        this.lAnteriorChamberStatus = lAnteriorChamberStatus == null ? null : lAnteriorChamberStatus.trim();
    }

    public String getrAnteriorChamberStatus() {
        return rAnteriorChamberStatus;
    }

    public void setrAnteriorChamberStatus(String rAnteriorChamberStatus) {
        this.rAnteriorChamberStatus = rAnteriorChamberStatus == null ? null : rAnteriorChamberStatus.trim();
    }

    public String getlIris() {
        return lIris;
    }

    public void setlIris(String lIris) {
        this.lIris = lIris == null ? null : lIris.trim();
    }

    public String getrIris() {
        return rIris;
    }

    public void setrIris(String rIris) {
        this.rIris = rIris == null ? null : rIris.trim();
    }

    public Float getlPupilDiameter() {
        return lPupilDiameter;
    }

    public void setlPupilDiameter(Float lPupilDiameter) {
        this.lPupilDiameter = lPupilDiameter;
    }

    public Float getrPupilDiameter() {
        return rPupilDiameter;
    }

    public void setrPupilDiameter(Float rPupilDiameter) {
        this.rPupilDiameter = rPupilDiameter;
    }

    public String getlPupilStatus() {
        return lPupilStatus;
    }

    public void setlPupilStatus(String lPupilStatus) {
        this.lPupilStatus = lPupilStatus == null ? null : lPupilStatus.trim();
    }

    public String getrPupilStatus() {
        return rPupilStatus;
    }

    public void setrPupilStatus(String rPupilStatus) {
        this.rPupilStatus = rPupilStatus == null ? null : rPupilStatus.trim();
    }

    public Integer getlPupilDirectLightReflection() {
        return lPupilDirectLightReflection;
    }

    public void setlPupilDirectLightReflection(Integer lPupilDirectLightReflection) {
        this.lPupilDirectLightReflection = lPupilDirectLightReflection;
    }

    public Integer getrPupilDirectLightReflection() {
        return rPupilDirectLightReflection;
    }

    public void setrPupilDirectLightReflection(Integer rPupilDirectLightReflection) {
        this.rPupilDirectLightReflection = rPupilDirectLightReflection;
    }

    public Integer getlPupilIndirectLightReflection() {
        return lPupilIndirectLightReflection;
    }

    public void setlPupilIndirectLightReflection(Integer lPupilIndirectLightReflection) {
        this.lPupilIndirectLightReflection = lPupilIndirectLightReflection;
    }

    public Integer getrPupilIndirectLightReflection() {
        return rPupilIndirectLightReflection;
    }

    public void setrPupilIndirectLightReflection(Integer rPupilIndirectLightReflection) {
        this.rPupilIndirectLightReflection = rPupilIndirectLightReflection;
    }

    public Integer getlPupilRapd() {
        return lPupilRapd;
    }

    public void setlPupilRapd(Integer lPupilRapd) {
        this.lPupilRapd = lPupilRapd;
    }

    public Integer getrPupilRapd() {
        return rPupilRapd;
    }

    public void setrPupilRapd(Integer rPupilRapd) {
        this.rPupilRapd = rPupilRapd;
    }

    public Integer getlLens() {
        return lLens;
    }

    public void setlLens(Integer lLens) {
        this.lLens = lLens;
    }

    public Integer getrLens() {
        return rLens;
    }

    public void setrLens(Integer rLens) {
        this.rLens = rLens;
    }

    public Integer getlNucleusChaosLev() {
        return lNucleusChaosLev;
    }

    public void setlNucleusChaosLev(Integer lNucleusChaosLev) {
        this.lNucleusChaosLev = lNucleusChaosLev;
    }

    public Integer getrNucleusChaosLev() {
        return rNucleusChaosLev;
    }

    public void setrNucleusChaosLev(Integer rNucleusChaosLev) {
        this.rNucleusChaosLev = rNucleusChaosLev;
    }

    public Integer getlIntraocularLens() {
        return lIntraocularLens;
    }

    public void setlIntraocularLens(Integer lIntraocularLens) {
        this.lIntraocularLens = lIntraocularLens;
    }

    public Integer getrIntraocularLens() {
        return rIntraocularLens;
    }

    public void setrIntraocularLens(Integer rIntraocularLens) {
        this.rIntraocularLens = rIntraocularLens;
    }

    public String getlVitreum() {
        return lVitreum;
    }

    public void setlVitreum(String lVitreum) {
        this.lVitreum = lVitreum == null ? null : lVitreum.trim();
    }

    public String getrVitreum() {
        return rVitreum;
    }

    public void setrVitreum(String rVitreum) {
        this.rVitreum = rVitreum == null ? null : rVitreum.trim();
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

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
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