package com.b.flog_backend.domains.exercise.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.b.flog_backend.domains.exercise.dto.ExerciseDto;

@Mapper
public interface ExerciseSqlMapper {

    // key로 DTO 조회
    public ExerciseDto getExerciseDtoById(int id);

    // 유저 아이디, 날짜별 조회
    public List<ExerciseDto> getExerciseByUserIdAndLogDate(@Param("userId") int userId, @Param("logDate") String logDate);



}
