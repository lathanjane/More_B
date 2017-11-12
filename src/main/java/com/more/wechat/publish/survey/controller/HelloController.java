package com.more.wechat.publish.survey.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.more.wechat.publish.survey.model.CustomerSurveyModel;
import com.more.wechat.publish.survey.service.CustomerSurveyService;

@RestController
public class HelloController {

	@Resource(name = CustomerSurveyService.BEAN_DEFAULT)
	CustomerSurveyService customerSurveyService;

	@RequestMapping(value = "/hello", method = { RequestMethod.POST })
	@ResponseBody
	public String index(@RequestBody CustomerSurveyModel customerSurveyModel) throws Exception {

		return customerSurveyService.saveCustomerSurvey(customerSurveyModel);

	}

}