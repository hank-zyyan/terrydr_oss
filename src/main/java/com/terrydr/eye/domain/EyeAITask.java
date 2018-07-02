package com.terrydr.eye.domain;

import java.util.Date;

public class EyeAITask {
    private String id;

    private Integer doctorId;

    private Integer examineId;

    private String examineEncryptId;

    private Integer examineType;

    private Integer detectionStatus;

    private Integer detectionType;

    private String detectionParams;

    private Integer detectionCount;

    private String detectionResult;

    private Date createTime;

    private Date resultTime;

    private Date lastUpdateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
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

    public Integer getExamineType() {
        return examineType;
    }

    public void setExamineType(Integer examineType) {
        this.examineType = examineType;
    }

    public Integer getDetectionStatus() {
        return detectionStatus;
    }

    public void setDetectionStatus(Integer detectionStatus) {
        this.detectionStatus = detectionStatus;
    }

    public Integer getDetectionType() {
        return detectionType;
    }

    public void setDetectionType(Integer detectionType) {
        this.detectionType = detectionType;
    }

    public String getDetectionParams() {
        return detectionParams;
    }

    public void setDetectionParams(String detectionParams) {
        this.detectionParams = detectionParams == null ? null : detectionParams.trim();
    }

    public Integer getDetectionCount() {
        return detectionCount;
    }

    public void setDetectionCount(Integer detectionCount) {
        this.detectionCount = detectionCount;
    }

    public String getDetectionResult() {
        return detectionResult;
    }

    public void setDetectionResult(String detectionResult) {
        this.detectionResult = detectionResult == null ? null : detectionResult.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getResultTime() {
        return resultTime;
    }

    public void setResultTime(Date resultTime) {
        this.resultTime = resultTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}