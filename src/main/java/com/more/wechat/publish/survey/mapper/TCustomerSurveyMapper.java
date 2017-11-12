package com.more.wechat.publish.survey.mapper;

import org.springframework.stereotype.Repository;

import com.more.wechat.publish.survey.model.TCustomerSurvey;

@Repository
public interface TCustomerSurveyMapper {
    int deleteByPrimaryKey(Long surveyId);

    int insert(TCustomerSurvey record);

    int insertSelective(TCustomerSurvey record);

    TCustomerSurvey selectByPrimaryKey(Long surveyId);

    int updateByPrimaryKeySelective(TCustomerSurvey record);

    int updateByPrimaryKey(TCustomerSurvey record);
}