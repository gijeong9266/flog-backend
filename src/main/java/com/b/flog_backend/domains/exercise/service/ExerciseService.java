package com.b.flog_backend.domains.exercise.service;

import com.b.flog_backend.domains.exercise.dto.ExerciseDto;
import com.b.flog_backend.domains.exercise.dto.ExerciseSetDto;
import com.b.flog_backend.domains.exercise.mapper.ExerciseSqlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {

    private final ExerciseSqlMapper exerciseSqlMapper;

    @Transactional
    public void insertExerciseAndSets(ExerciseDto exerciseDto, List<ExerciseSetDto> exerciseSetDtos) {
        exerciseSqlMapper.insertExercise(exerciseDto);
        int exerciseId = exerciseDto.getId();
        for (ExerciseSetDto exerciseSetDto : exerciseSetDtos) {
            exerciseSetDto.setExerciseId(exerciseId);
            exerciseSqlMapper.insertExerciseSet(exerciseSetDto);
        }
    }
}
