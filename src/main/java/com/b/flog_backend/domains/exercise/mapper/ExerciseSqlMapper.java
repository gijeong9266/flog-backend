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

    // 유저 아이디별 운동날짜리스트 가져오기
    public List<String> getRecordedDatesByUserId(int userId);

}
