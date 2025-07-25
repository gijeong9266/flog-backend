package com.b.flog_backend.domains.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.b.flog_backend.domains.exercise.dto.ExerciseDto;
import com.b.flog_backend.domains.exercise.dto.ExerciseLogRequestDto;
import com.b.flog_backend.domains.exercise.dto.ExercisePayloadDto;
import com.b.flog_backend.domains.exercise.dto.ExerciseSetDto;
import com.b.flog_backend.domains.exercise.mapper.ExerciseDomainMapper;
import com.b.flog_backend.domains.exercise.mapper.ExerciseSqlMapper;

@Service
public class ExerciseServiceImpl {
    @Autowired
    private ExerciseSqlMapper exerciseSqlMapper;

    @Autowired
    private ExerciseDomainMapper exerciseDomainMapper;

    // 유저 아이디, 날짜별 조회
    // public List<ExerciseDto> getExerciseLog(int userId, String logDate) {
    //     return exerciseSqlMapper.getExerciseByUserIdAndLogDate(userId, logDate);
    // }

    public List<ExercisePayloadDto> getExerciseLog(int userId, String logDate){

        List<ExerciseDto> exerciseDtos = exerciseSqlMapper.getExerciseByUserIdAndLogDate(userId, logDate);
        List<ExercisePayloadDto> exercisePayloads = new ArrayList<>();

        for (ExerciseDto exerciseDto : exerciseDtos) {
            List<ExerciseSetDto> setDtos = exerciseSqlMapper.getExerciseSetsByExerciseId(exerciseDto.getId());

            ExercisePayloadDto payload = new ExercisePayloadDto();
            payload.setExerciseName(exerciseDto.getExerciseName()); 
            payload.setSector(exerciseDto.getSector());
            payload.setSets(setDtos);
            if(exerciseDto.getLogDate() != null){
                payload.setLogDate(exerciseDto.getLogDate().toString());
            }
            if (exerciseDto.getLogTime() != null){
                payload.setLogTime(exerciseDto.getLogTime().toString());
            }

            exercisePayloads.add(payload);
        }

        return exercisePayloads;

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
