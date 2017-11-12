package com.more.wechat.publish.survey.model;

import java.util.Date;

public class TSurveyQuestionOption {
    private Long questionOptionId;

    private Long questionId;

    private String questionOptionCode;

    private String questionOptionDesc;

    private Integer subQuestionFlag;

    private Long refQuestionId;

    private String insertBy;

    private Date insertTime;

    private Date insertTimestamp;

    private String updateBy;

    private Date updateTime;

    private Date updateTimestamp;

    public Long getQuestionOptionId() {
        return questionOptionId;
    }

    public void setQuestionOptionId(Long questionOptionId) {
        this.questionOptionId = questionOptionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionOptionCode() {
        return questionOptionCode;
    }

    public void setQuestionOptionCode(String questionOptionCode) {
        this.questionOptionCode = questionOptionCode == null ? null : questionOptionCode.trim();
    }

    public String getQuestionOptionDesc() {
        return questionOptionDesc;
    }

    public void setQuestionOptionDesc(String questionOptionDesc) {
        this.questionOptionDesc = questionOptionDesc == null ? null : questionOptionDesc.trim();
    }

    public Integer getSubQuestionFlag() {
        return subQuestionFlag;
    }

    public void setSubQuestionFlag(Integer subQuestionFlag) {
        this.subQuestionFlag = subQuestionFlag;
    }

    public Long getRefQuestionId() {
        return refQuestionId;
    }

    public void setRefQuestionId(Long refQuestionId) {
        this.refQuestionId = refQuestionId;
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