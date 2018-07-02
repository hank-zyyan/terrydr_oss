package com.terrydr.eye.domain;

import java.util.Date;

public class EyeCustomer {
    private Integer id;

    private String encryptId;

    private String name;

    private Integer sex;

    private Date birthday;

    private String teleno;

    private String idCard;

    private String lpProvId;

    private String lpProvName;

    private String lpCityId;

    private String lpCityName;

    private String lpAreaId;

    private String lpAreaName;

    private String livePlace;

    private String hrProvId;

    private String hrProvName;

    private String hrCityId;

    private String hrCityName;

    private String hrAreaId;

    private String hrAreaName;

    private String householdRegister;

    private Integer medicalCardType;

    private String medicalCardId;

    private Integer nationId;

    private String nationName;

    private String occupation;

    private String employmentSituation;

    private Integer educationLevels;

    private Integer maritalStatus;

    private Integer doctorId;

    private String doctorName;

    private Integer hospitalId;

    private String hospitalName;

    private Date createTime;

    private Integer patientId;

    private Integer isDiabetes;

    private Date diabetesDiagnosisDate;

    private Integer diabetesStatus;

    private Integer isHypertension;

    private Date hypertensionDiagnosisDate;

    private Integer hypertensionStatus;

    private String diseasesOther;

    private Integer oculoIsGlaucoma;

    private Integer oculoIsDr;

    private String oculoOther;

    private Integer familyIsGlaucoma;

    private Integer familyIsHypertension;

    private String familyOther;

    private String smoke;

    private String drink;

    private String sport;

    private String electrTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTeleno() {
        return teleno;
    }

    public void setTeleno(String teleno) {
        this.teleno = teleno == null ? null : teleno.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getLpProvId() {
        return lpProvId;
    }

    public void setLpProvId(String lpProvId) {
        this.lpProvId = lpProvId == null ? null : lpProvId.trim();
    }

    public String getLpProvName() {
        return lpProvName;
    }

    public void setLpProvName(String lpProvName) {
        this.lpProvName = lpProvName == null ? null : lpProvName.trim();
    }

    public String getLpCityId() {
        return lpCityId;
    }

    public void setLpCityId(String lpCityId) {
        this.lpCityId = lpCityId == null ? null : lpCityId.trim();
    }

    public String getLpCityName() {
        return lpCityName;
    }

    public void setLpCityName(String lpCityName) {
        this.lpCityName = lpCityName == null ? null : lpCityName.trim();
    }

    public String getLpAreaId() {
        return lpAreaId;
    }

    public void setLpAreaId(String lpAreaId) {
        this.lpAreaId = lpAreaId == null ? null : lpAreaId.trim();
    }

    public String getLpAreaName() {
        return lpAreaName;
    }

    public void setLpAreaName(String lpAreaName) {
        this.lpAreaName = lpAreaName == null ? null : lpAreaName.trim();
    }

    public String getLivePlace() {
        return livePlace;
    }

    public void setLivePlace(String livePlace) {
        this.livePlace = livePlace == null ? null : livePlace.trim();
    }

    public String getHrProvId() {
        return hrProvId;
    }

    public void setHrProvId(String hrProvId) {
        this.hrProvId = hrProvId == null ? null : hrProvId.trim();
    }

    public String getHrProvName() {
        return hrProvName;
    }

    public void setHrProvName(String hrProvName) {
        this.hrProvName = hrProvName == null ? null : hrProvName.trim();
    }

    public String getHrCityId() {
        return hrCityId;
    }

    public void setHrCityId(String hrCityId) {
        this.hrCityId = hrCityId == null ? null : hrCityId.trim();
    }

    public String getHrCityName() {
        return hrCityName;
    }

    public void setHrCityName(String hrCityName) {
        this.hrCityName = hrCityName == null ? null : hrCityName.trim();
    }

    public String getHrAreaId() {
        return hrAreaId;
    }

    public void setHrAreaId(String hrAreaId) {
        this.hrAreaId = hrAreaId == null ? null : hrAreaId.trim();
    }

    public String getHrAreaName() {
        return hrAreaName;
    }

    public void setHrAreaName(String hrAreaName) {
        this.hrAreaName = hrAreaName == null ? null : hrAreaName.trim();
    }

    public String getHouseholdRegister() {
        return householdRegister;
    }

    public void setHouseholdRegister(String householdRegister) {
        this.householdRegister = householdRegister == null ? null : householdRegister.trim();
    }

    public Integer getMedicalCardType() {
        return medicalCardType;
    }

    public void setMedicalCardType(Integer medicalCardType) {
        this.medicalCardType = medicalCardType;
    }

    public String getMedicalCardId() {
        return medicalCardId;
    }

    public void setMedicalCardId(String medicalCardId) {
        this.medicalCardId = medicalCardId == null ? null : medicalCardId.trim();
    }

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName == null ? null : nationName.trim();
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation == null ? null : occupation.trim();
    }

    public String getEmploymentSituation() {
        return employmentSituation;
    }

    public void setEmploymentSituation(String employmentSituation) {
        this.employmentSituation = employmentSituation == null ? null : employmentSituation.trim();
    }

    public Integer getEducationLevels() {
        return educationLevels;
    }

    public void setEducationLevels(Integer educationLevels) {
        this.educationLevels = educationLevels;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getIsDiabetes() {
        return isDiabetes;
    }

    public void setIsDiabetes(Integer isDiabetes) {
        this.isDiabetes = isDiabetes;
    }

    public Date getDiabetesDiagnosisDate() {
        return diabetesDiagnosisDate;
    }

    public void setDiabetesDiagnosisDate(Date diabetesDiagnosisDate) {
        this.diabetesDiagnosisDate = diabetesDiagnosisDate;
    }

    public Integer getDiabetesStatus() {
        return diabetesStatus;
    }

    public void setDiabetesStatus(Integer diabetesStatus) {
        this.diabetesStatus = diabetesStatus;
    }

    public Integer getIsHypertension() {
        return isHypertension;
    }

    public void setIsHypertension(Integer isHypertension) {
        this.isHypertension = isHypertension;
    }

    public Date getHypertensionDiagnosisDate() {
        return hypertensionDiagnosisDate;
    }

    public void setHypertensionDiagnosisDate(Date hypertensionDiagnosisDate) {
        this.hypertensionDiagnosisDate = hypertensionDiagnosisDate;
    }

    public Integer getHypertensionStatus() {
        return hypertensionStatus;
    }

    public void setHypertensionStatus(Integer hypertensionStatus) {
        this.hypertensionStatus = hypertensionStatus;
    }

    public String getDiseasesOther() {
        return diseasesOther;
    }

    public void setDiseasesOther(String diseasesOther) {
        this.diseasesOther = diseasesOther == null ? null : diseasesOther.trim();
    }

    public Integer getOculoIsGlaucoma() {
        return oculoIsGlaucoma;
    }

    public void setOculoIsGlaucoma(Integer oculoIsGlaucoma) {
        this.oculoIsGlaucoma = oculoIsGlaucoma;
    }

    public Integer getOculoIsDr() {
        return oculoIsDr;
    }

    public void setOculoIsDr(Integer oculoIsDr) {
        this.oculoIsDr = oculoIsDr;
    }

    public String getOculoOther() {
        return oculoOther;
    }

    public void setOculoOther(String oculoOther) {
        this.oculoOther = oculoOther == null ? null : oculoOther.trim();
    }

    public Integer getFamilyIsGlaucoma() {
        return familyIsGlaucoma;
    }

    public void setFamilyIsGlaucoma(Integer familyIsGlaucoma) {
        this.familyIsGlaucoma = familyIsGlaucoma;
    }

    public Integer getFamilyIsHypertension() {
        return familyIsHypertension;
    }

    public void setFamilyIsHypertension(Integer familyIsHypertension) {
        this.familyIsHypertension = familyIsHypertension;
    }

    public String getFamilyOther() {
        return familyOther;
    }

    public void setFamilyOther(String familyOther) {
        this.familyOther = familyOther == null ? null : familyOther.trim();
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke == null ? null : smoke.trim();
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink == null ? null : drink.trim();
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport == null ? null : sport.trim();
    }

    public String getElectrTime() {
        return electrTime;
    }

    public void setElectrTime(String electrTime) {
        this.electrTime = electrTime == null ? null : electrTime.trim();
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