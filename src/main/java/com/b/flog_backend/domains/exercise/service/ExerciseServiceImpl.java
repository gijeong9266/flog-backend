package com.b.flog_backend.domains.exercise.service;

import java.util.List;

import com.b.flog_backend.domains.exercise.dto.ExerciseDto;
import com.b.flog_backend.domains.exercise.mapper.ExerciseSqlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b.flog_backend.domains.exercise.dto.ExerciseLogRequestDto;
import com.b.flog_backend.domains.exercise.dto.ExercisePayloadDto;
import com.b.flog_backend.domains.exercise.dto.ExerciseSetDto;
import com.b.flog_backend.domains.exercise.mapper.ExerciseDomainMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExerciseServiceImpl {
    @Autowired
    private ExerciseSqlMapper exerciseSqlMapper;

    @Autowired
    private ExerciseDomainMapper exerciseDomainMapper;

    // 유저 아이디, 날짜별 조회
    public List<ExerciseDto> getExerciseLog(int userId, String logDate) {
        return exerciseSqlMapper.getExerciseByUserIdAndLogDate(userId, logDate);
    }

    // 유저 아이디별 운동날짜리스트 가져오기
    public List<String> getRecordedDates(int userId) {
        return exerciseSqlMapper.getRecordedDatesByUserId(userId);
    }

    @Transactional
    public void addFullExerciseLog(ExerciseLogRequestDto requestDto, int userId) {
        for (ExercisePayloadDto exercisePayload : requestDto.getExercises()) {
            ExerciseDto exerciseDto = exerciseDomainMapper.toExerciseDto(exercisePayload, requestDto, userId);
            exerciseSqlMapper.insertExercise(exerciseDto);
            int exerciseId = exerciseDto.getId();

            for (ExerciseSetDto exerciseSetDto : exercisePayload.getSets()) {
                exerciseSetDto.setExerciseId(exerciseId);
                exerciseSqlMapper.insertExerciseSet(exerciseSetDto);
            }
        }
    }
}
