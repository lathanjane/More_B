package com.more.wechat.publish.survey.model;

import java.util.Date;

public class TCustomerSurveyDetail {
	private Long detailId;

	private Long surveyId;

	private String questionCode;

	private Long questionOptionId;

	private String questionOptionCode;

	private String questionAnswerTxt1;

	private String questionAnswerTxt2;

	private String questionAnswerTxt3;

	private String questionAnswerTxt4;

	private String reservedField1;

	private String reservedField2;

	private String reservedField3;

	private String insertBy;

	private Date insertTime;

	private Date insertTimestamp;

	private String updateBy;

	private Date updateTime;

	private Date updateTimestamp;

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode == null ? null : questionCode.trim();
	}

	public Long getQuestionOptionId() {
		return questionOptionId;
	}

	public void setQuestionOptionId(Long questionOptionId) {
		this.questionOptionId = questionOptionId;
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

	public String getReservedField1() {
		return reservedField1;
	}

	public void setReservedField1(String reservedField1) {
		this.reservedField1 = reservedField1 == null ? null : reservedField1.trim();
	}

	public String getReservedField2() {
		return reservedField2;
	}

	public void setReservedField2(String reservedField2) {
		this.reservedField2 = reservedField2 == null ? null : reservedField2.trim();
	}

	public String getReservedField3() {
		return reservedField3;
	}

	public void setReservedField3(String reservedField3) {
		this.reservedField3 = reservedField3 == null ? null : reservedField3.trim();
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