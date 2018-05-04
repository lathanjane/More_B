package com.more.wechat.publish.survey.model;

import java.util.Date;

public class TSurveyQuestion {
    private Long questionId;

    private String questionCode;

    private Long surveyTemplateId;

    private String surveyQuestionName;

    private String parentQuestion;

    private String questionType;

    private String questionAnswerNum;

    private String questionOrder;

    private String insertBy;

    private Date insertTime;

    private Date insertTimestamp;

    private String updateBy;

    private Date updateTime;

    private Date updateTimestamp;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode == null ? null : questionCode.trim();
    }

    public Long getSurveyTemplateId() {
        return surveyTemplateId;
    }

    public void setSurveyTemplateId(Long surveyTemplateId) {
        this.surveyTemplateId = surveyTemplateId;
    }

    public String getSurveyQuestionName() {
        return surveyQuestionName;
    }

    public void setSurveyQuestionName(String surveyQuestionName) {
        this.surveyQuestionName = surveyQuestionName == null ? null : surveyQuestionName.trim();
    }

    public String getParentQuestion() {
        return parentQuestion;
    }

    public void setParentQuestion(String parentQuestion) {
        this.parentQuestion = parentQuestion == null ? null : parentQuestion.trim();
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
    }

    public String getQuestionAnswerNum() {
        return questionAnswerNum;
    }

    public void setQuestionAnswerNum(String questionAnswerNum) {
        this.questionAnswerNum = questionAnswerNum == null ? null : questionAnswerNum.trim();
    }

    public String getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(String questionOrder) {
        this.questionOrder = questionOrder == null ? null : questionOrder.trim();
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