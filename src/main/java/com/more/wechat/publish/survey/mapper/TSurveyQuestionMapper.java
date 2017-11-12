package com.more.wechat.publish.survey.mapper;

import com.more.wechat.publish.survey.model.TSurveyQuestion;

public interface TSurveyQuestionMapper {
    int deleteByPrimaryKey(Long questionId);

    int insert(TSurveyQuestion record);

    int insertSelective(TSurveyQuestion record);

    TSurveyQuestion selectByPrimaryKey(Long questionId);

    int updateByPrimaryKeySelective(TSurveyQuestion record);

    int updateByPrimaryKey(TSurveyQuestion record);
}