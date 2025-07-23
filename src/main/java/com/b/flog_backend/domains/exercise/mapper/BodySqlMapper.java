package com.b.flog_backend.domains.exercise.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.b.flog_backend.domains.exercise.dto.BodyDto;

@Mapper
public interface BodySqlMapper {

    // 신체 정보 입력
    public void insertBodyInfo(BodyDto bodyDto);

    // 신체 정보 가져오기
    public BodyDto getBodyInfoByUserId(int userId);

}
