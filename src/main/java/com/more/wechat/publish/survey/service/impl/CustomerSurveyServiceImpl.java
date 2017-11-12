package com.more.wechat.publish.survey.service.impl;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.more.wechat.publish.survey.common.AgeUtils;
import com.more.wechat.publish.survey.common.AuditUtil;
import com.more.wechat.publish.survey.common.DateUtil;
import com.more.wechat.publish.survey.common.RandomUtil;
import com.more.wechat.publish.survey.mapper.TCustomerSurveyDetailMapper;
import com.more.wechat.publish.survey.mapper.TCustomerSurveyMapper;
import com.more.wechat.publish.survey.model.CustomerSurveyModel;
import com.more.wechat.publish.survey.model.TCustomerSurvey;
import com.more.wechat.publish.survey.model.TCustomerSurveyDetail;
import com.more.wechat.publish.survey.service.CustomerSurveyService;

@Service(CustomerSurveyService.BEAN_DEFAULT)
public class CustomerSurveyServiceImpl implements CustomerSurveyService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerSurveyServiceImpl.class);

	@Autowired
	private TCustomerSurveyMapper TCustomerSurveyMapper;
	@Autowired
	private TCustomerSurveyDetailMapper TCustomerSurveyDetailMapper;

	@Override
	public String saveCustomerSurvey(CustomerSurveyModel customerSurveyModel) {
		try {

			String surveyTemplateId = customerSurveyModel.getSurveyTemplateId();

			// 目前只支持健康问卷
			if (surveyTemplateId != null && surveyTemplateId.equals("1")) {

				Map<String, String> questionMap = customerSurveyModel.getQuestionMap();

				// 生成主键
				Long surveyId = Long.valueOf(RandomUtil.getRandomKeyCode("", 5));

				Map<String, String> answerMap = new HashMap<String, String>();

				TCustomerSurvey tCustomerSurvey = new TCustomerSurvey();
				for (int i = 0; i < 100; i++) {
					String answer = questionMap.get("question" + (i + 1));
					if (answer != null && answer.length() != 0) {
						tCustomerSurvey = getCustomerSurvey(questionMap, surveyId, Long.valueOf(surveyTemplateId), i,
								tCustomerSurvey);
					}
				}
				if (tCustomerSurvey != null) {
					TCustomerSurveyMapper.insert(tCustomerSurvey);
				}
				for (int i = 0; i < 100; i++) {
					String answer = questionMap.get("question" + (i + 1));
					if (answer != null && answer.length() != 0) {
						TCustomerSurveyDetail tCustomerSurveyDetail = getCustomerSurveyDetail(questionMap, surveyId,
								Long.valueOf(surveyTemplateId), i);
						if (tCustomerSurveyDetail != null) {
							TCustomerSurveyDetailMapper.insert(tCustomerSurveyDetail);
						}
						getAnswerMap(questionMap, i, answerMap);
					}
				}

				return getRuleResult(answerMap);
			}

			return "";
		} catch (Exception e) {
			logger.error("保存客户问卷失败。", e);
			return null;
		}
	}

	private void setCustomerSurveyProperties(TCustomerSurvey tCustomerSurvey) throws ParseException {

		tCustomerSurvey.setSurveyObject("1");// 调查对象 (1. 默认个人客户)
		// tCustomerSurvey.setCustomerId();
		tCustomerSurvey.setInsertBy(AuditUtil.getDefaultUser());
		tCustomerSurvey.setInsertTime(AuditUtil.getDefaultDateTime());
		tCustomerSurvey.setInsertTimestamp(AuditUtil.getDefaultDateTime());
		tCustomerSurvey.setUpdateBy(AuditUtil.getDefaultUser());
		tCustomerSurvey.setUpdateTime(AuditUtil.getDefaultDateTime());
		tCustomerSurvey.setUpdateTimestamp(AuditUtil.getDefaultDateTime());
	}

	private void setCustomerSurveyDetailProperties(TCustomerSurveyDetail tCustomerSurveyDetail) throws ParseException {

		tCustomerSurveyDetail.setInsertBy(AuditUtil.getDefaultUser());
		tCustomerSurveyDetail.setInsertTime(AuditUtil.getDefaultDateTime());
		tCustomerSurveyDetail.setInsertTimestamp(AuditUtil.getDefaultDateTime());
		tCustomerSurveyDetail.setUpdateBy(AuditUtil.getDefaultUser());
		tCustomerSurveyDetail.setUpdateTime(AuditUtil.getDefaultDateTime());
		tCustomerSurveyDetail.setUpdateTimestamp(AuditUtil.getDefaultDateTime());
	}

	private TCustomerSurveyDetail getCustomerSurveyDetail(Map<String, String> questionMap, Long surveyId,
			Long surveyTemplateId, int index) throws Exception {

		TCustomerSurveyDetail tCustomerSurveyDetail = new TCustomerSurveyDetail();
		String answer = questionMap.get("question" + (index + 1));
		if (answer != null && answer.length() != 0) {
			logger.info("i = ", String.valueOf(index));
			tCustomerSurveyDetail.setSurveyId(surveyId);
			tCustomerSurveyDetail.setQuestionCode(String.valueOf(index + 1));
			setCustomerSurveyDetailProperties(tCustomerSurveyDetail);

			switch (index + 1) {
			case 1:
				tCustomerSurveyDetail.setQuestionOptionCode(answer);
				break;
			case 7:
				tCustomerSurveyDetail.setQuestionOptionCode(answer);
				break;
			case 8:
				tCustomerSurveyDetail.setQuestionOptionCode(answer);
				break;
			case 9:
				tCustomerSurveyDetail.setQuestionOptionCode(answer);
				break;
			case 12:
				tCustomerSurveyDetail.setQuestionOptionCode(answer);
				break;
			case 16:
				tCustomerSurveyDetail.setQuestionOptionCode(answer);
				break;
			case 17:
				tCustomerSurveyDetail.setQuestionOptionCode(answer);
				break;
			case 10:
			case 11:
			case 13:
			case 15:
			case 18:
			case 19:
			case 20:
			case 25:
			case 27:
				tCustomerSurveyDetail.setQuestionOptionCode(answer);
				break;
			case 2:
				tCustomerSurveyDetail.setQuestionOptionCode(answer);
				break;
			case 6:
				tCustomerSurveyDetail.setQuestionAnswerTxt1(answer);
				break;
			case 3:
			case 4:
			case 5:
			case 14:
			case 21:
			case 22:
			case 23:
			case 24:
			case 26:
			case 28:
			case 30:
			case 31:
			case 32:
			case 34:
			case 35:
				tCustomerSurveyDetail.setQuestionAnswerTxt1(answer);
				break;
			case 29:
				String[] answerList = answer.split(",");
				tCustomerSurveyDetail.setQuestionAnswerTxt1(answerList[0]);
				tCustomerSurveyDetail.setQuestionAnswerTxt2(answerList[1]);
				break;
			}
		}
		return tCustomerSurveyDetail;
	}

	private Map<String, String> getAnswerMap(Map<String, String> questionMap, int index, Map<String, String> answerMap)
			throws Exception {

		String answer = questionMap.get("question" + (index + 1));
		if (answer != null && answer.length() != 0) {
			logger.info("i = ", String.valueOf(index));

			switch (index + 1) {
			case 1:
				answerMap.put("Answer1", answer);
				break;
			case 7:
				answerMap.put("Answer7", answer);
				break;
			case 8:
				answerMap.put("Answer8", answer);
				break;
			case 9:
				answerMap.put("Answer9", answer);
				break;
			case 12:
				answerMap.put("Answer12", answer);
				break;
			case 16:
				answerMap.put("Answer16", answer);
				break;
			case 17:
				answerMap.put("Answer17", answer);
				break;
			case 10:
			case 11:
			case 13:
			case 15:
			case 18:
			case 19:
			case 20:
			case 25:
			case 27:
				break;
			case 2:
				answerMap.put("Answer2", answer);
				break;
			case 6:
				answerMap.put("Answer6", answer);
				break;
			case 3:
			case 4:
			case 5:
			case 14:
			case 21:
			case 22:
			case 23:
			case 24:
			case 26:
			case 28:
			case 30:
			case 31:
			case 32:
			case 34:
			case 35:
				break;
			case 29:
				break;
			}
		}
		return answerMap;

	}

	private TCustomerSurvey getCustomerSurvey(Map<String, String> questionMap, Long surveyId, Long surveyTemplateId,
			int index, TCustomerSurvey tCustomerSurvey) throws Exception {
		String answer = questionMap.get("question" + (index + 1));
		if (answer != null && answer.length() != 0) {
			logger.info("i = ", String.valueOf(index));
			tCustomerSurvey.setSurveyId(surveyId);
			tCustomerSurvey.setSurveyTemplateId(surveyTemplateId);
			setCustomerSurveyProperties(tCustomerSurvey);

			switch (index + 1) {
			case 1:
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				break;
			case 12:
				break;
			case 16:
				break;
			case 17:
				break;
			case 10:
			case 11:
			case 13:
			case 15:
			case 18:
			case 19:
			case 20:
			case 25:
			case 27:
				break;
			case 2:
				tCustomerSurvey.setPhBirthday(DateUtil.parseDate(answer));
				break;
			case 6:
				break;
			case 3:
			case 4:
			case 5:
			case 14:
			case 21:
			case 22:
			case 23:
			case 24:
			case 26:
			case 28:
			case 30:
			case 31:
			case 32:
			case 34:
			case 35:
				break;
			case 29:
				break;
			}
		}
		return tCustomerSurvey;
	}

	/**
	 * 获取规则逻辑及结果
	 * 
	 * @param answerMap
	 * @return
	 */
	private String getRuleResult(Map<String, String> answerMap) {

		int trueRuleCount = 0; // 规则满足数量
		boolean rule1 = false;//  年龄：男45以上，女55以上
		if (answerMap.get("Answer1") != null && answerMap.get("Answer1").length() != 0
				&& answerMap.get("Answer2") != null && answerMap.get("Answer2").length() != 0) {
			if (answerMap.get("Answer1").equals(1)) {
				if (AgeUtils.getAgeFromBirthTime(answerMap.get("Answer2")) > 45) {
					rule1 = true;// 男45以上
				}
			} else if (answerMap.get("Answer1").equals(2)) {
				if (AgeUtils.getAgeFromBirthTime(answerMap.get("Answer2")) > 55) {
					rule1 = true; // 女55以上
				}
			}
		}
		logger.info("rule1：年龄：男45以上，女55以上:" + rule1);
		if (rule1) {
			trueRuleCount++;
		}

		boolean rule2 = false;//  吸烟
		if (answerMap.get("Answer9") != null && answerMap.get("Answer9").length() != 0) {
			if (answerMap.get("Answer9").equals("1")) {
				rule2 = true;
			}
		}
		logger.info("rule2：吸烟：" + rule2);
		if (rule2) {
			trueRuleCount++;
		}

		boolean rule3 = false;//  久坐少动
		if (answerMap.get("Answer11") != null && answerMap.get("Answer11").length() != 0) {
			if (answerMap.get("Answer11").equals("1")) {
				rule3 = true;
			}
		}
		logger.info("rule3：久坐少动：" + rule3);
		if (rule3) {
			trueRuleCount++;
		}
		boolean rule4 = false;//  BMI大于等于25
		if (answerMap.get("Answer6") != null && answerMap.get("Answer6").length() != 0) {
			if (Integer.valueOf(answerMap.get("Answer6")) >= 25) {
				rule4 = true;
			}
		}
		logger.info("rule4：BMI大于等于25：" + rule4);
		if (rule4) {
			trueRuleCount++;
		}

		boolean rule5 = false;//  有高血糖且无既往病史、无家族遗传病史
		if (answerMap.get("Answer7") != null && answerMap.get("Answer7").length() != 0
				&& answerMap.get("Answer8") != null && answerMap.get("Answer8").length() != 0
				&& answerMap.get("Answer17") != null && answerMap.get("Answer17").length() != 0) {
			if (answerMap.get("Answer17").equals("1") && answerMap.get("Answer7").equals("0")
					&& answerMap.get("Answer8").equals("0")) {
				rule5 = true;
			}
		}
		logger.info("rule5：有高血糖且无既往病史、无家族遗传病史：" + rule5);
		if (rule5) {
			trueRuleCount++;
		}

		boolean rule6 = false;//  有高血脂且无既往病史、无家族遗传病史
		if (answerMap.get("Answer7") != null && answerMap.get("Answer7").length() != 0
				&& answerMap.get("Answer8") != null && answerMap.get("Answer8").length() != 0
				&& answerMap.get("Answer17") != null && answerMap.get("Answer16").length() != 0) {
			if (answerMap.get("Answer16").equals("1") && answerMap.get("Answer7").equals("0")
					&& answerMap.get("Answer8").equals("0")) {
				rule6 = true;
			}
		}
		logger.info("rule6：有高血脂且无既往病史、无家族遗传病史：" + rule6);
		if (rule6) {
			trueRuleCount++;
		}

		boolean rule7 = false;//  有家族遗传病史，本人无既往病史
		if (answerMap.get("Answer7") != null && answerMap.get("Answer7").length() != 0
				&& answerMap.get("Answer8") != null && answerMap.get("Answer8").length() != 0) {
			if (answerMap.get("Answer7").equals("0") && answerMap.get("Answer8").equals("1")) {
				rule7 = true;
			}
		}
		logger.info("rule7：有家族遗传病史，本人无既往病史：" + rule7);
		if (!rule7) {
			trueRuleCount++;
		}

		if (answerMap.get("Answer7").equals(1) || answerMap.get("Answer12").equals(1)) {
			return "D";
		}
		if (trueRuleCount <= 1) {
			return "A";
		} else {
			if (answerMap.get("Answer1").equals(1)) {
				return "B";
			}
			if (answerMap.get("Answer1").equals(0)) {
				return "C";
			}

		}
		return null;
	}
}
