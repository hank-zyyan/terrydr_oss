package com.terrydr.eye.domain;

import java.util.Date;

public class EyeReport {
    private Integer reportId;

    private String shareId;

    private Integer reportType;

    private Integer examineType;

    private Integer encounterId;

    private String encounterEncryptId;

    private Integer examineId;

    private String examineEncryptId;

    private Integer doctorId;

    private String doctorName;

    private String doctorTeleno;

    private String doctorAvatar;

    private Integer customerId;

    private String customerEncryptId;

    private Integer hospitalId;

    private String hospitalName;

    private Integer reportHospId;

    private String reportHospName;

    private String reportCover;

    private String submitUnit;

    private String submitDoctor;

    private String submitDepartment;

    private String admissionNo;

    private Date examDate;

    private String bedNo;

    private String clinicalSymptom;

    private String clinicalDiagnosis;

    private String reportImg;

    private String eyeLeftVision;

    private String eyeRightVision;

    private String eyeLeftImg;

    private String eyeRightImg;

    private String remarks;

    private Integer isEnterprise;

    private String electronicSignature;

    private Date createTime;

    private Date lastUpdateTime;

    private Integer isDeleted;

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId == null ? null : shareId.trim();
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public Integer getExamineType() {
        return examineType;
    }

    public void setExamineType(Integer examineType) {
        this.examineType = examineType;
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

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public String getDoctorTeleno() {
        return doctorTeleno;
    }

    public void setDoctorTeleno(String doctorTeleno) {
        this.doctorTeleno = doctorTeleno == null ? null : doctorTeleno.trim();
    }

    public String getDoctorAvatar() {
        return doctorAvatar;
    }

    public void setDoctorAvatar(String doctorAvatar) {
        this.doctorAvatar = doctorAvatar == null ? null : doctorAvatar.trim();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEncryptId() {
        return customerEncryptId;
    }

    public void setCustomerEncryptId(String customerEncryptId) {
        this.customerEncryptId = customerEncryptId == null ? null : customerEncryptId.trim();
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName == null ? null : hospitalName.trim();
    }

    public Integer getReportHospId() {
        return reportHospId;
    }

    public void setReportHospId(Integer reportHospId) {
        this.reportHospId = reportHospId;
    }

    public String getReportHospName() {
        return reportHospName;
    }

    public void setReportHospName(String reportHospName) {
        this.reportHospName = reportHospName == null ? null : reportHospName.trim();
    }

    public String getReportCover() {
        return reportCover;
    }

    public void setReportCover(String reportCover) {
        this.reportCover = reportCover == null ? null : reportCover.trim();
    }

    public String getSubmitUnit() {
        return submitUnit;
    }

    public void setSubmitUnit(String submitUnit) {
        this.submitUnit = submitUnit == null ? null : submitUnit.trim();
    }

    public String getSubmitDoctor() {
        return submitDoctor;
    }

    public void setSubmitDoctor(String submitDoctor) {
        this.submitDoctor = submitDoctor == null ? null : submitDoctor.trim();
    }

    public String getSubmitDepartment() {
        return submitDepartment;
    }

    public void setSubmitDepartment(String submitDepartment) {
        this.submitDepartment = submitDepartment == null ? null : submitDepartment.trim();
    }

    public String getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo == null ? null : admissionNo.trim();
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo == null ? null : bedNo.trim();
    }

    public String getClinicalSymptom() {
        return clinicalSymptom;
    }

    public void setClinicalSymptom(String clinicalSymptom) {
        this.clinicalSymptom = clinicalSymptom == null ? null : clinicalSymptom.trim();
    }

    public String getClinicalDiagnosis() {
        return clinicalDiagnosis;
    }

    public void setClinicalDiagnosis(String clinicalDiagnosis) {
        this.clinicalDiagnosis = clinicalDiagnosis == null ? null : clinicalDiagnosis.trim();
    }

    public String getReportImg() {
        return reportImg;
    }

    public void setReportImg(String reportImg) {
        this.reportImg = reportImg == null ? null : reportImg.trim();
    }

    public String getEyeLeftVision() {
        return eyeLeftVision;
    }

    public void setEyeLeftVision(String eyeLeftVision) {
        this.eyeLeftVision = eyeLeftVision == null ? null : eyeLeftVision.trim();
    }

    public String getEyeRightVision() {
        return eyeRightVision;
    }

    public void setEyeRightVision(String eyeRightVision) {
        this.eyeRightVision = eyeRightVision == null ? null : eyeRightVision.trim();
    }

    public String getEyeLeftImg() {
        return eyeLeftImg;
    }

    public void setEyeLeftImg(String eyeLeftImg) {
        this.eyeLeftImg = eyeLeftImg == null ? null : eyeLeftImg.trim();
    }

    public String getEyeRightImg() {
        return eyeRightImg;
    }

    public void setEyeRightImg(String eyeRightImg) {
        this.eyeRightImg = eyeRightImg == null ? null : eyeRightImg.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getIsEnterprise() {
        return isEnterprise;
    }

    public void setIsEnterprise(Integer isEnterprise) {
        this.isEnterprise = isEnterprise;
    }

    public String getElectronicSignature() {
        return electronicSignature;
    }

    public void setElectronicSignature(String electronicSignature) {
        this.electronicSignature = electronicSignature == null ? null : electronicSignature.trim();
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}