package com.more.wechat.publish.survey.mapper;

import com.more.wechat.publish.survey.model.TSurveyTemplate;

public interface TSurveyTemplateMapper {
    int deleteByPrimaryKey(Long surveyTemplateId);

    int insert(TSurveyTemplate record);

    int insertSelective(TSurveyTemplate record);

    TSurveyTemplate selectByPrimaryKey(Long surveyTemplateId);

    int updateByPrimaryKeySelective(TSurveyTemplate record);

    int updateByPrimaryKey(TSurveyTemplate record);
}