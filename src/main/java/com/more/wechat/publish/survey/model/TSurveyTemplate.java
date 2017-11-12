package com.more.wechat.publish.survey.model;

import java.util.Date;

public class TSurveyTemplate {
    private Long surveyTemplateId;

    private String surveyTemplCode;

    private String templateName;

    private Integer surveyObject;

    private Integer surveyType;

    private Date defineTime;

    private String definedBy;

    private String insertBy;

    private Date insertTime;

    private Date insertTimestamp;

    private String updateBy;

    private Date updateTime;

    private Date updateTimestamp;

    public Long getSurveyTemplateId() {
        return surveyTemplateId;
    }

    public void setSurveyTemplateId(Long surveyTemplateId) {
        this.surveyTemplateId = surveyTemplateId;
    }

    public String getSurveyTemplCode() {
        return surveyTemplCode;
    }

    public void setSurveyTemplCode(String surveyTemplCode) {
        this.surveyTemplCode = surveyTemplCode == null ? null : surveyTemplCode.trim();
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName == null ? null : templateName.trim();
    }

    public Integer getSurveyObject() {
        return surveyObject;
    }

    public void setSurveyObject(Integer surveyObject) {
        this.surveyObject = surveyObject;
    }

    public Integer getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(Integer surveyType) {
        this.surveyType = surveyType;
    }

    public Date getDefineTime() {
        return defineTime;
    }

    public void setDefineTime(Date defineTime) {
        this.defineTime = defineTime;
    }

    public String getDefinedBy() {
        return definedBy;
    }

    public void setDefinedBy(String definedBy) {
        this.definedBy = definedBy == null ? null : definedBy.trim();
    }

    public String getInsertBy() {
        return insertBy;
    }

    public void setInsertBy(String insertBy) {
        this.insertBy = insertBy == null ? null : insertBy.trim();
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getInsertTimestamp() {
        return insertTimestamp;
    }

    public void setInsertTimestamp(Date insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }
}