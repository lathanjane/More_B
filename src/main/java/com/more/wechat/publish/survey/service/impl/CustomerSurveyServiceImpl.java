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
import com.more.wechat.publish.survey.mapper.TSurveyQuestionMapper;
import com.more.wechat.publish.survey.model.CustomerSurveyModel;
import com.more.wechat.publish.survey.model.TCustomerSurvey;
import com.more.wechat.publish.survey.model.TCustomerSurveyDetail;
import com.more.wechat.publish.survey.model.TSurveyQuestion;
import com.more.wechat.publish.survey.service.CustomerSurveyService;

@Service(CustomerSurveyService.BEAN_DEFAULT)
public class CustomerSurveyServiceImpl implements CustomerSurveyService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerSurveyServiceImpl.class);

	@Autowired
	private TCustomerSurveyMapper TCustomerSurveyMapper;
	@Autowired
	private TCustomerSurveyDetailMapper TCustomerSurveyDetailMapper;
	@Autowired
	private TSurveyQuestionMapper TSurveyQuestionMapper;

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
					String answer = questionMap.get("value" + (i + 1));
					if (answer != null && answer.length() != 0) {
						tCustomerSurvey = getCustomerSurvey(questionMap, surveyId, Long.valueOf(surveyTemplateId), i,
								tCustomerSurvey);
					}
				}
				if (tCustomerSurvey != null) {
					TCustomerSurveyMapper.insert(tCustomerSurvey);
				}
				for (int i = 0; i < 100; i++) {
					String answer = questionMap.get("value" + (i + 1));
					if (answer != null && answer.length() != 0) {
						TCustomerSurveyDetail tCustomerSurveyDetail = getCustomerSurveyDetail(questionMap, surveyId,
								Long.valueOf(surveyTemplateId), i);
						if (tCustomerSurveyDetail != null) {
							TCustomerSurveyDetailMapper.insert(tCustomerSurveyDetail);
						}
						getAnswerMap(questionMap, i, answerMap);
					}
				}

				String r = getRuleResult(answerMap);
				logger.info("返回结果：" + r);
				return r;
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
		String answer = questionMap.get("value" + (index + 1));
		if (answer != null && answer.length() != 0) {
			tCustomerSurveyDetail.setSurveyId(surveyId);
			tCustomerSurveyDetail.setQuestionCode(String.valueOf(index + 1));
			setCustomerSurveyDetailProperties(tCustomerSurveyDetail);

			TSurveyQuestion tSurveyQuestion = new TSurveyQuestion();
			tSurveyQuestion.setQuestionCode(String.valueOf(index + 1));
			tSurveyQuestion = TSurveyQuestionMapper.selectByTSurveyQuestion(tSurveyQuestion);

			if (tSurveyQuestion != null && tSurveyQuestion.getQuestionType() != null
					&& tSurveyQuestion.getQuestionType().length() != 0) {
				// 3- 单选题
				if (tSurveyQuestion.getQuestionType().equals("3") || tSurveyQuestion.getQuestionType().equals("1")) {
					tCustomerSurveyDetail.setQuestionOptionCode(answer);
				} else if (tSurveyQuestion.getQuestionType().equals("2")) {
					// 2- 填空题
					String[] answerList = answer.split(",");
					if (answerList.length >= 1) {
						tCustomerSurveyDetail.setQuestionAnswerTxt1(answerList[0]);
					}
					if (answerList.length >= 2) {
						tCustomerSurveyDetail.setQuestionAnswerTxt2(answerList[1]);
					}
					if (answerList.length >= 3) {
						tCustomerSurveyDetail.setQuestionAnswerTxt3(answerList[2]);
					}
					if (answerList.length >= 4) {
						tCustomerSurveyDetail.setQuestionAnswerTxt4(answerList[3]);
					}
				}
			}
		}
		return tCustomerSurveyDetail;
	}

	private Map<String, String> getAnswerMap(Map<String, String> questionMap, int index, Map<String, String> answerMap)
			throws Exception {
		String answer = questionMap.get("value" + (index + 1));
		if (answer != null && answer.length() != 0) {
			answerMap.put("Answer" + (index + 1), answer);
		}
		return answerMap;

	}

	private TCustomerSurvey getCustomerSurvey(Map<String, String> questionMap, Long surveyId, Long surveyTemplateId,
			int index, TCustomerSurvey tCustomerSurvey) throws Exception {
		String answer = questionMap.get("value" + (index + 1));
		if (answer != null && answer.length() != 0) {
			tCustomerSurvey.setSurveyId(surveyId);
			tCustomerSurvey.setSurveyTemplateId(surveyTemplateId);
			setCustomerSurveyProperties(tCustomerSurvey);
			if ((index + 1) == 2) {
				tCustomerSurvey.setPhBirthday(DateUtil.parseDate(answer));
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
			if (answerMap.get("Answer1").equals("1")) {
				if (AgeUtils.getAgeFromBirthTime(answerMap.get("Answer2")) > 45) {
					rule1 = true;// 男45以上
				}
			} else if (answerMap.get("Answer1").equals("2")) {
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
			if (Double.valueOf(answerMap.get("Answer6")) >= 25) {
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

		if (answerMap.get("Answer7").equals("1") || answerMap.get("Answer12").equals("1")) {
			return "D";
		}
		if (trueRuleCount <= 1) {
			return "A";
		} else {
			if (answerMap.get("Answer1").equals("1")) {
				return "B";
			}
			if (answerMap.get("Answer1").equals("2")) {
				return "C";
			}

		}
		return null;
	}
}
