package com.more.wechat.publish.survey.mapper;

import com.more.wechat.publish.survey.model.TCustomerSurveyDetail;

public interface TCustomerSurveyDetailMapper {
    int deleteByPrimaryKey(Long detailId);

    int insert(TCustomerSurveyDetail record);

    int insertSelective(TCustomerSurveyDetail record);

    TCustomerSurveyDetail selectByPrimaryKey(Long detailId);

    int updateByPrimaryKeySelective(TCustomerSurveyDetail record);

    int updateByPrimaryKey(TCustomerSurveyDetail record);
}