package com.linb.model;

import java.util.Date;

/**
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table pacs_case
 */
public class TestModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.pacs_case_id
     *
     * @FieldComment 
     *
     * @mbggenerated
     */
    private String pacsCaseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.pacs_patient_id
     *
     * @FieldComment 影像病人id
     *
     * @mbggenerated
     */
    private String pacsPatientId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.ycyx_case_id
     *
     * @FieldComment 远程影像病例id
     *
     * @mbggenerated
     */
    private String ycyxCaseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.from_doctor
     *
     * @FieldComment 来源医生
     *
     * @mbggenerated
     */
    private String fromDoctor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.from_hospital
     *
     * @FieldComment 来源医院，病人默认医院
     *
     * @mbggenerated
     */
    private String fromHospital;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.to_doctor
     *
     * @FieldComment 诊断医生
     *
     * @mbggenerated
     */
    private String toDoctor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.to_hospital
     *
     * @FieldComment 诊断医生所在医院
     *
     * @mbggenerated
     */
    private String toHospital;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.case_type
     *
     * @FieldComment 检查类型-前缀；对应于远程影像的模态modality
     *
     * @mbggenerated
     */
    private String caseType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.case_type_name
     *
     * @FieldComment 检查类型-后缀；对应于远程影像的检查部位inspect_part
     *
     * @mbggenerated
     */
    private String caseTypeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.case_no
     *
     * @FieldComment 病例号
     *
     * @mbggenerated
     */
    private String caseNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.visit_id_1
     *
     * @FieldComment 门诊号
     *
     * @mbggenerated
     */
    private String visitId1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.visit_id_2
     *
     * @FieldComment 住院号
     *
     * @mbggenerated
     */
    private String visitId2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.profession
     *
     * @FieldComment 病人主诉
     *
     * @mbggenerated
     */
    private String profession;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.clinical_data
     *
     * @FieldComment 病史摘要
     *
     * @mbggenerated
     */
    private String clinicalData;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.clinic_diagnosis
     *
     * @FieldComment 临床诊断
     *
     * @mbggenerated
     */
    private String clinicDiagnosis;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.gennerally_see
     *
     * @FieldComment 影像表现
     *
     * @mbggenerated
     */
    private String gennerallySee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.diagnosis
     *
     * @FieldComment 影像诊断
     *
     * @mbggenerated
     */
    private String diagnosis;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.view_count
     *
     * @FieldComment 点击数
     *
     * @mbggenerated
     */
    private Integer viewCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.is_delete
     *
     * @FieldComment 删除标识，1未删除，0删除
     *
     * @mbggenerated
     */
    private String isDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.is_show
     *
     * @FieldComment 是否发布，1发布，0未发布
     *
     * @mbggenerated
     */
    private String isShow;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.is_read_dicom
     *
     * @FieldComment 是否显示于读片会，1是，0否
     *
     * @mbggenerated
     */
    private String isReadDicom;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.show_time
     *
     * @FieldComment 发布时间
     *
     * @mbggenerated
     */
    private Date showTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.create_time
     *
     * @FieldComment 创建时间
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.update_time
     *
     * @FieldComment 修改时间
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.temp1
     *
     * @FieldComment 备用1
     *
     * @mbggenerated
     */
    private String temp1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.temp2
     *
     * @FieldComment 备用2
     *
     * @mbggenerated
     */
    private String temp2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.temp3
     *
     * @FieldComment 备用3
     *
     * @mbggenerated
     */
    private String temp3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.temp4
     *
     * @FieldComment 备用4
     *
     * @mbggenerated
     */
    private String temp4;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.temp5
     *
     * @FieldComment 备用5
     *
     * @mbggenerated
     */
    private String temp5;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pacs_case.temp6
     *
     * @FieldComment 备用6
     *
     * @mbggenerated
     */
    private String temp6;

    public String examItem; // 检查项目，多个已英文逗号隔开
    
    private String hospitalNo; // 医院组织代码
    
    private String sex; // 性别
    
    private Integer age; // 年龄
    
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHospitalNo() {
        return hospitalNo;
    }

    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo;
    }
    
    public String getExamItem() {
        return examItem;
    }

    public void setExamItem(String examItem) {
        this.examItem = examItem;
    }
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.pacs_case_id
     *
     * @FieldComment 
     *
     * @return the value of pacs_case.pacs_case_id
     *
     * @mbggenerated
     */
    public String getPacsCaseId() {
        return pacsCaseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.pacs_case_id
     *
     * @FieldComment 
     *
     * @param pacsCaseId the value for pacs_case.pacs_case_id
     *
     * @mbggenerated
     */
    public void setPacsCaseId(String pacsCaseId) {
        this.pacsCaseId = pacsCaseId == null ? null : pacsCaseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.pacs_patient_id
     *
     * @FieldComment 影像病人id
     *
     * @return the value of pacs_case.pacs_patient_id
     *
     * @mbggenerated
     */
    public String getPacsPatientId() {
        return pacsPatientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.pacs_patient_id
     *
     * @FieldComment 影像病人id
     *
     * @param pacsPatientId the value for pacs_case.pacs_patient_id
     *
     * @mbggenerated
     */
    public void setPacsPatientId(String pacsPatientId) {
        this.pacsPatientId = pacsPatientId == null ? null : pacsPatientId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.ycyx_case_id
     *
     * @FieldComment 远程影像病例id
     *
     * @return the value of pacs_case.ycyx_case_id
     *
     * @mbggenerated
     */
    public String getYcyxCaseId() {
        return ycyxCaseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.ycyx_case_id
     *
     * @FieldComment 远程影像病例id
     *
     * @param ycyxCaseId the value for pacs_case.ycyx_case_id
     *
     * @mbggenerated
     */
    public void setYcyxCaseId(String ycyxCaseId) {
        this.ycyxCaseId = ycyxCaseId == null ? null : ycyxCaseId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.from_doctor
     *
     * @FieldComment 来源医生
     *
     * @return the value of pacs_case.from_doctor
     *
     * @mbggenerated
     */
    public String getFromDoctor() {
        return fromDoctor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.from_doctor
     *
     * @FieldComment 来源医生
     *
     * @param fromDoctor the value for pacs_case.from_doctor
     *
     * @mbggenerated
     */
    public void setFromDoctor(String fromDoctor) {
        this.fromDoctor = fromDoctor == null ? null : fromDoctor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.from_hospital
     *
     * @FieldComment 来源医院，病人默认医院
     *
     * @return the value of pacs_case.from_hospital
     *
     * @mbggenerated
     */
    public String getFromHospital() {
        return fromHospital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.from_hospital
     *
     * @FieldComment 来源医院，病人默认医院
     *
     * @param fromHospital the value for pacs_case.from_hospital
     *
     * @mbggenerated
     */
    public void setFromHospital(String fromHospital) {
        this.fromHospital = fromHospital == null ? null : fromHospital.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.to_doctor
     *
     * @FieldComment 诊断医生
     *
     * @return the value of pacs_case.to_doctor
     *
     * @mbggenerated
     */
    public String getToDoctor() {
        return toDoctor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.to_doctor
     *
     * @FieldComment 诊断医生
     *
     * @param toDoctor the value for pacs_case.to_doctor
     *
     * @mbggenerated
     */
    public void setToDoctor(String toDoctor) {
        this.toDoctor = toDoctor == null ? null : toDoctor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.to_hospital
     *
     * @FieldComment 诊断医生所在医院
     *
     * @return the value of pacs_case.to_hospital
     *
     * @mbggenerated
     */
    public String getToHospital() {
        return toHospital;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.to_hospital
     *
     * @FieldComment 诊断医生所在医院
     *
     * @param toHospital the value for pacs_case.to_hospital
     *
     * @mbggenerated
     */
    public void setToHospital(String toHospital) {
        this.toHospital = toHospital == null ? null : toHospital.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.case_type
     *
     * @FieldComment 检查类型-前缀；对应于远程影像的模态modality
     *
     * @return the value of pacs_case.case_type
     *
     * @mbggenerated
     */
    public String getCaseType() {
        return caseType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.case_type
     *
     * @FieldComment 检查类型-前缀；对应于远程影像的模态modality
     *
     * @param caseType the value for pacs_case.case_type
     *
     * @mbggenerated
     */
    public void setCaseType(String caseType) {
        this.caseType = caseType == null ? null : caseType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.case_type_name
     *
     * @FieldComment 检查类型-后缀；对应于远程影像的检查部位inspect_part
     *
     * @return the value of pacs_case.case_type_name
     *
     * @mbggenerated
     */
    public String getCaseTypeName() {
        return caseTypeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.case_type_name
     *
     * @FieldComment 检查类型-后缀；对应于远程影像的检查部位inspect_part
     *
     * @param caseTypeName the value for pacs_case.case_type_name
     *
     * @mbggenerated
     */
    public void setCaseTypeName(String caseTypeName) {
        this.caseTypeName = caseTypeName == null ? null : caseTypeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.case_no
     *
     * @FieldComment 病例号
     *
     * @return the value of pacs_case.case_no
     *
     * @mbggenerated
     */
    public String getCaseNo() {
        return caseNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.case_no
     *
     * @FieldComment 病例号
     *
     * @param caseNo the value for pacs_case.case_no
     *
     * @mbggenerated
     */
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo == null ? null : caseNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.visit_id_1
     *
     * @FieldComment 门诊号
     *
     * @return the value of pacs_case.visit_id_1
     *
     * @mbggenerated
     */
    public String getVisitId1() {
        return visitId1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.visit_id_1
     *
     * @FieldComment 门诊号
     *
     * @param visitId1 the value for pacs_case.visit_id_1
     *
     * @mbggenerated
     */
    public void setVisitId1(String visitId1) {
        this.visitId1 = visitId1 == null ? null : visitId1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.visit_id_2
     *
     * @FieldComment 住院号
     *
     * @return the value of pacs_case.visit_id_2
     *
     * @mbggenerated
     */
    public String getVisitId2() {
        return visitId2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.visit_id_2
     *
     * @FieldComment 住院号
     *
     * @param visitId2 the value for pacs_case.visit_id_2
     *
     * @mbggenerated
     */
    public void setVisitId2(String visitId2) {
        this.visitId2 = visitId2 == null ? null : visitId2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.profession
     *
     * @FieldComment 病人主诉
     *
     * @return the value of pacs_case.profession
     *
     * @mbggenerated
     */
    public String getProfession() {
        return profession;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.profession
     *
     * @FieldComment 病人主诉
     *
     * @param profession the value for pacs_case.profession
     *
     * @mbggenerated
     */
    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.clinical_data
     *
     * @FieldComment 病史摘要
     *
     * @return the value of pacs_case.clinical_data
     *
     * @mbggenerated
     */
    public String getClinicalData() {
        return clinicalData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.clinical_data
     *
     * @FieldComment 病史摘要
     *
     * @param clinicalData the value for pacs_case.clinical_data
     *
     * @mbggenerated
     */
    public void setClinicalData(String clinicalData) {
        this.clinicalData = clinicalData == null ? null : clinicalData.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.clinic_diagnosis
     *
     * @FieldComment 临床诊断
     *
     * @return the value of pacs_case.clinic_diagnosis
     *
     * @mbggenerated
     */
    public String getClinicDiagnosis() {
        return clinicDiagnosis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.clinic_diagnosis
     *
     * @FieldComment 临床诊断
     *
     * @param clinicDiagnosis the value for pacs_case.clinic_diagnosis
     *
     * @mbggenerated
     */
    public void setClinicDiagnosis(String clinicDiagnosis) {
        this.clinicDiagnosis = clinicDiagnosis == null ? null : clinicDiagnosis.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.gennerally_see
     *
     * @FieldComment 影像表现
     *
     * @return the value of pacs_case.gennerally_see
     *
     * @mbggenerated
     */
    public String getGennerallySee() {
        return gennerallySee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.gennerally_see
     *
     * @FieldComment 影像表现
     *
     * @param gennerallySee the value for pacs_case.gennerally_see
     *
     * @mbggenerated
     */
    public void setGennerallySee(String gennerallySee) {
        this.gennerallySee = gennerallySee == null ? null : gennerallySee.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.diagnosis
     *
     * @FieldComment 影像诊断
     *
     * @return the value of pacs_case.diagnosis
     *
     * @mbggenerated
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.diagnosis
     *
     * @FieldComment 影像诊断
     *
     * @param diagnosis the value for pacs_case.diagnosis
     *
     * @mbggenerated
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.view_count
     *
     * @FieldComment 点击数
     *
     * @return the value of pacs_case.view_count
     *
     * @mbggenerated
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.view_count
     *
     * @FieldComment 点击数
     *
     * @param viewCount the value for pacs_case.view_count
     *
     * @mbggenerated
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.is_delete
     *
     * @FieldComment 删除标识，1未删除，0删除
     *
     * @return the value of pacs_case.is_delete
     *
     * @mbggenerated
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.is_delete
     *
     * @FieldComment 删除标识，1未删除，0删除
     *
     * @param isDelete the value for pacs_case.is_delete
     *
     * @mbggenerated
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.is_show
     *
     * @FieldComment 是否发布，1发布，0未发布
     *
     * @return the value of pacs_case.is_show
     *
     * @mbggenerated
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.is_show
     *
     * @FieldComment 是否发布，1发布，0未发布
     *
     * @param isShow the value for pacs_case.is_show
     *
     * @mbggenerated
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.is_read_dicom
     *
     * @FieldComment 是否显示于读片会，1是，0否
     *
     * @return the value of pacs_case.is_read_dicom
     *
     * @mbggenerated
     */
    public String getIsReadDicom() {
        return isReadDicom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.is_read_dicom
     *
     * @FieldComment 是否显示于读片会，1是，0否
     *
     * @param isReadDicom the value for pacs_case.is_read_dicom
     *
     * @mbggenerated
     */
    public void setIsReadDicom(String isReadDicom) {
        this.isReadDicom = isReadDicom == null ? null : isReadDicom.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.show_time
     *
     * @FieldComment 发布时间
     *
     * @return the value of pacs_case.show_time
     *
     * @mbggenerated
     */
    public Date getShowTime() {
        return showTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.show_time
     *
     * @FieldComment 发布时间
     *
     * @param showTime the value for pacs_case.show_time
     *
     * @mbggenerated
     */
    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.create_time
     *
     * @FieldComment 创建时间
     *
     * @return the value of pacs_case.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.create_time
     *
     * @FieldComment 创建时间
     *
     * @param createTime the value for pacs_case.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.update_time
     *
     * @FieldComment 修改时间
     *
     * @return the value of pacs_case.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.update_time
     *
     * @FieldComment 修改时间
     *
     * @param updateTime the value for pacs_case.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.temp1
     *
     * @FieldComment 备用1
     *
     * @return the value of pacs_case.temp1
     *
     * @mbggenerated
     */
    public String getTemp1() {
        return temp1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.temp1
     *
     * @FieldComment 备用1
     *
     * @param temp1 the value for pacs_case.temp1
     *
     * @mbggenerated
     */
    public void setTemp1(String temp1) {
        this.temp1 = temp1 == null ? null : temp1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.temp2
     *
     * @FieldComment 备用2
     *
     * @return the value of pacs_case.temp2
     *
     * @mbggenerated
     */
    public String getTemp2() {
        return temp2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.temp2
     *
     * @FieldComment 备用2
     *
     * @param temp2 the value for pacs_case.temp2
     *
     * @mbggenerated
     */
    public void setTemp2(String temp2) {
        this.temp2 = temp2 == null ? null : temp2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.temp3
     *
     * @FieldComment 备用3
     *
     * @return the value of pacs_case.temp3
     *
     * @mbggenerated
     */
    public String getTemp3() {
        return temp3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.temp3
     *
     * @FieldComment 备用3
     *
     * @param temp3 the value for pacs_case.temp3
     *
     * @mbggenerated
     */
    public void setTemp3(String temp3) {
        this.temp3 = temp3 == null ? null : temp3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.temp4
     *
     * @FieldComment 备用4
     *
     * @return the value of pacs_case.temp4
     *
     * @mbggenerated
     */
    public String getTemp4() {
        return temp4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.temp4
     *
     * @FieldComment 备用4
     *
     * @param temp4 the value for pacs_case.temp4
     *
     * @mbggenerated
     */
    public void setTemp4(String temp4) {
        this.temp4 = temp4 == null ? null : temp4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.temp5
     *
     * @FieldComment 备用5
     *
     * @return the value of pacs_case.temp5
     *
     * @mbggenerated
     */
    public String getTemp5() {
        return temp5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.temp5
     *
     * @FieldComment 备用5
     *
     * @param temp5 the value for pacs_case.temp5
     *
     * @mbggenerated
     */
    public void setTemp5(String temp5) {
        this.temp5 = temp5 == null ? null : temp5.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pacs_case.temp6
     *
     * @FieldComment 备用6
     *
     * @return the value of pacs_case.temp6
     *
     * @mbggenerated
     */
    public String getTemp6() {
        return temp6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pacs_case.temp6
     *
     * @FieldComment 备用6
     *
     * @param temp6 the value for pacs_case.temp6
     *
     * @mbggenerated
     */
    public void setTemp6(String temp6) {
        this.temp6 = temp6 == null ? null : temp6.trim();
    }
}