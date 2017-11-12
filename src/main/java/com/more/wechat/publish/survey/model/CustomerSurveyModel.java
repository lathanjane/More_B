package com.more.wechat.publish.survey.model;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CustomerSurveyModel {

	/**
	 * 问卷模板ID
	 */
	private String surveyTemplateId;

	/**
	 * 问题列表
	 */
	private Map<String ,String> questionMap;

	public String getSurveyTemplateId() {
		return surveyTemplateId;
	}

	public void setSurveyTemplateId(String surveyTemplateId) {
		this.surveyTemplateId = surveyTemplateId;
	}

	public Map<String, String> getQuestionMap() {
		return questionMap;
	}

	public void setQuestionMap(Map<String, String> questionMap) {
		this.questionMap = questionMap;
	}
	
}
