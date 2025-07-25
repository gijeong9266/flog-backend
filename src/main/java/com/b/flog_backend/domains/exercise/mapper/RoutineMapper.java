package com.b.flog_backend.domains.exercise.mapper;

import com.b.flog_backend.domains.exercise.dto.ExerciseDto;
import com.b.flog_backend.domains.exercise.dto.RoutineDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoutineMapper {
    void insertRoutine(RoutineDto routineDto);
    void insertExercises(List<ExerciseDto> exercises);
}
