package com.more.wechat.publish.survey.mapper;

import com.more.wechat.publish.survey.model.TSurveyQuestionOption;

public interface TSurveyQuestionOptionMapper {
    int deleteByPrimaryKey(Long questionOptionId);

    int insert(TSurveyQuestionOption record);

    int insertSelective(TSurveyQuestionOption record);

    TSurveyQuestionOption selectByPrimaryKey(Long questionOptionId);

    int updateByPrimaryKeySelective(TSurveyQuestionOption record);

    int updateByPrimaryKey(TSurveyQuestionOption record);
}