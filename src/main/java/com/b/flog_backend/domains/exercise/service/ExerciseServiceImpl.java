package com.b.flog_backend.domains.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b.flog_backend.domains.exercise.dto.ExerciseDto;
import com.b.flog_backend.domains.exercise.mapper.ExerciseSqlMapper;

@Service
public class ExerciseServiceImpl {
    @Autowired
    private ExerciseSqlMapper exerciseSqlMapper;

    // 유저 아이디, 날짜별 조회
    public List<ExerciseDto> getExerciseLog(int userId, String logDate) {
        return exerciseSqlMapper.getExerciseByUserIdAndLogDate(userId, logDate);
    }

    // 유저 아이디별 운동날짜리스트 가져오기
    public List<String> getRecordedDates(int userId) {
        return exerciseSqlMapper.getRecordedDatesByUserId(userId);
    }
}
