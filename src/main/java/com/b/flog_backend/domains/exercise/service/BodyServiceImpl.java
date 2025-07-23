package com.b.flog_backend.domains.exercise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b.flog_backend.domains.exercise.dto.BodyDto;
import com.b.flog_backend.domains.exercise.mapper.BodySqlMapper;

@Service
public class BodyServiceImpl {
    @Autowired
    private BodySqlMapper bodySqlMapper;

    // 신체정보입력
    public void insertBodyInfo(BodyDto bodyDto){
        bodySqlMapper.insertBodyInfo(bodyDto);
    }

    // 신체정보 가져오기
    public BodyDto getBodyInfo(int userId){
        return bodySqlMapper.getBodyInfoByUserId(userId);
    }


}
