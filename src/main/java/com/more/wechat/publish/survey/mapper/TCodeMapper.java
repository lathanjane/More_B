package com.more.wechat.publish.survey.mapper;

import com.more.wechat.publish.survey.model.TCode;

public interface TCodeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCode record);

    int insertSelective(TCode record);

    TCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCode record);

    int updateByPrimaryKey(TCode record);
}