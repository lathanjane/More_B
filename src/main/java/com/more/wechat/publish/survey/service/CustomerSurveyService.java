package com.more.wechat.publish.survey.service;

import com.more.wechat.publish.survey.model.CustomerSurveyModel;

public interface CustomerSurveyService {
	String BEAN_DEFAULT = "CustomerSurveyService";

	public String saveCustomerSurvey(CustomerSurveyModel customerSurveyModelList) throws Exception;
}
