package com.terrydr.eye.domain;

import java.util.Date;

public class EyeConsultation {
    private Integer id;

    private Integer examineType;

    private Integer examineId;

    private String examineEncryptId;

    private Integer consultationType;

    private Integer createDoctorId;

    private Integer consultationDoctorId;

    private String consultationDoctorName;

    private String consultationDoctorTeleno;

    private String consultationDoctorAvatar;

    private Integer consultationHospitalId;

    private String consultationHospitalName;

    private Date createTime;

    private Date endTime;

    private Integer status;

    private String description;

    private String closeUserType;

    private Date lastUpdateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExamineType() {
        return examineType;
    }

    public void setExamineType(Integer examineType) {
        this.examineType = examineType;
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

    public Integer getConsultationType() {
        return consultationType;
    }

    public void setConsultationType(Integer consultationType) {
        this.consultationType = consultationType;
    }

    public Integer getCreateDoctorId() {
        return createDoctorId;
    }

    public void setCreateDoctorId(Integer createDoctorId) {
        this.createDoctorId = createDoctorId;
    }

    public Integer getConsultationDoctorId() {
        return consultationDoctorId;
    }

    public void setConsultationDoctorId(Integer consultationDoctorId) {
        this.consultationDoctorId = consultationDoctorId;
    }

    public String getConsultationDoctorName() {
        return consultationDoctorName;
    }

    public void setConsultationDoctorName(String consultationDoctorName) {
        this.consultationDoctorName = consultationDoctorName == null ? null : consultationDoctorName.trim();
    }

    public String getConsultationDoctorTeleno() {
        return consultationDoctorTeleno;
    }

    public void setConsultationDoctorTeleno(String consultationDoctorTeleno) {
        this.consultationDoctorTeleno = consultationDoctorTeleno == null ? null : consultationDoctorTeleno.trim();
    }

    public String getConsultationDoctorAvatar() {
        return consultationDoctorAvatar;
    }

    public void setConsultationDoctorAvatar(String consultationDoctorAvatar) {
        this.consultationDoctorAvatar = consultationDoctorAvatar == null ? null : consultationDoctorAvatar.trim();
    }

    public Integer getConsultationHospitalId() {
        return consultationHospitalId;
    }

    public void setConsultationHospitalId(Integer consultationHospitalId) {
        this.consultationHospitalId = consultationHospitalId;
    }

    public String getConsultationHospitalName() {
        return consultationHospitalName;
    }

    public void setConsultationHospitalName(String consultationHospitalName) {
        this.consultationHospitalName = consultationHospitalName == null ? null : consultationHospitalName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCloseUserType() {
        return closeUserType;
    }

    public void setCloseUserType(String closeUserType) {
        this.closeUserType = closeUserType == null ? null : closeUserType.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}