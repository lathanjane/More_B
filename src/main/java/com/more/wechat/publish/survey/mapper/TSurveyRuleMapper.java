package com.more.wechat.publish.survey.mapper;

import com.more.wechat.publish.survey.model.TSurveyRule;

public interface TSurveyRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TSurveyRule record);

    int insertSelective(TSurveyRule record);

    TSurveyRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSurveyRule record);

    int updateByPrimaryKey(TSurveyRule record);
}