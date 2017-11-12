package com.more.wechat.publish.survey.model;

public class TSurveyRule {
    private Integer id;

    private Long surveyTemplateId;

    private String questionCode;

    private String questionAnswerRule;

    private String questionOptionCode;

    private String questionAnswerTxt1;

    private String questionAnswerTxt2;

    private String questionAnswerTxt3;

    private String questionAnswerTxt4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getSurveyTemplateId() {
        return surveyTemplateId;
    }

    public void setSurveyTemplateId(Long surveyTemplateId) {
        this.surveyTemplateId = surveyTemplateId;
    }

    public String getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(String questionCode) {
        this.questionCode = questionCode == null ? null : questionCode.trim();
    }

    public String getQuestionAnswerRule() {
        return questionAnswerRule;
    }

    public void setQuestionAnswerRule(String questionAnswerRule) {
        this.questionAnswerRule = questionAnswerRule == null ? null : questionAnswerRule.trim();
    }

    public String getQuestionOptionCode() {
        return questionOptionCode;
    }

    public void setQuestionOptionCode(String questionOptionCode) {
        this.questionOptionCode = questionOptionCode == null ? null : questionOptionCode.trim();
    }

    public String getQuestionAnswerTxt1() {
        return questionAnswerTxt1;
    }

    public void setQuestionAnswerTxt1(String questionAnswerTxt1) {
        this.questionAnswerTxt1 = questionAnswerTxt1 == null ? null : questionAnswerTxt1.trim();
    }

    public String getQuestionAnswerTxt2() {
        return questionAnswerTxt2;
    }

    public void setQuestionAnswerTxt2(String questionAnswerTxt2) {
        this.questionAnswerTxt2 = questionAnswerTxt2 == null ? null : questionAnswerTxt2.trim();
    }

    public String getQuestionAnswerTxt3() {
        return questionAnswerTxt3;
    }

    public void setQuestionAnswerTxt3(String questionAnswerTxt3) {
        this.questionAnswerTxt3 = questionAnswerTxt3 == null ? null : questionAnswerTxt3.trim();
    }

    public String getQuestionAnswerTxt4() {
        return questionAnswerTxt4;
    }

    public void setQuestionAnswerTxt4(String questionAnswerTxt4) {
        this.questionAnswerTxt4 = questionAnswerTxt4 == null ? null : questionAnswerTxt4.trim();
    }
}