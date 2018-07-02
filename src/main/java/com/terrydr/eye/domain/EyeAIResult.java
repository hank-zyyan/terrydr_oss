package com.terrydr.eye.domain;

import java.util.Date;

public class EyeAIResult extends EyeAIResultKey {
    private String detectionResult;

    private Integer detectionStatus;

    private Date createTime;

    private Date resultTime;

    private Date lastUpdateTime;

    public String getDetectionResult() {
        return detectionResult;
    }

    public void setDetectionResult(String detectionResult) {
        this.detectionResult = detectionResult == null ? null : detectionResult.trim();
    }

    public Integer getDetectionStatus() {
        return detectionStatus;
    }

    public void setDetectionStatus(Integer detectionStatus) {
        this.detectionStatus = detectionStatus;
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