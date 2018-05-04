package com.more.wechat.publish.survey.mapper;

import com.more.wechat.publish.survey.model.TCustomerSurvey;

public interface TCustomerSurveyMapper {
    int deleteByPrimaryKey(Long surveyId);

    int insert(TCustomerSurvey record);

    int insertSelective(TCustomerSurvey record);

    TCustomerSurvey selectByPrimaryKey(Long surveyId);

    int updateByPrimaryKeySelective(TCustomerSurvey record);

    int updateByPrimaryKey(TCustomerSurvey record);
}