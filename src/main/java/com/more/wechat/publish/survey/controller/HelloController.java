package com.more.wechat.publish.survey.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.more.wechat.publish.common.CommonUtil;
import com.more.wechat.publish.survey.model.CustomerSurveyModel;
import com.more.wechat.publish.survey.model.OutPutModel;
import com.more.wechat.publish.survey.model.SurveySuggestion;
import com.more.wechat.publish.survey.service.CustomerSurveyService;

@RestController
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Resource(name = CustomerSurveyService.BEAN_DEFAULT)
	CustomerSurveyService customerSurveyService;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping(value = "/saveCustomerSurvey", method = { RequestMethod.POST })
	@ResponseBody
	public String index(@RequestBody CustomerSurveyModel customerSurveyModel) throws Exception {

		OutPutModel opm = new OutPutModel();
		logger.info("接收的报文参数：{}", CommonUtil.objToJson(customerSurveyModel));
		try {
			String suggestion = customerSurveyService.saveCustomerSurvey(customerSurveyModel);
			SurveySuggestion rSurveySuggestion = new SurveySuggestion();
			rSurveySuggestion.setSuggestion(suggestion);
			rSurveySuggestion.setSurveyTemplateId(customerSurveyModel.getSurveyTemplateId());

			opm.setData(rSurveySuggestion);
			opm.setSuccess(true);
		} catch (Exception e) {
			logger.error("程序发生异常：{}", e);
			opm.setData(new SurveySuggestion());
			opm.setSuccess(false);
		}

		String suggestionJson = CommonUtil.objToJson(opm);
		logger.info("返回的报文参数：{}", suggestionJson);
		return suggestionJson;

	}

}