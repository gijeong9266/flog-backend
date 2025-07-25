package com.b.flog_backend.domains.exercise.service;

import com.b.flog_backend.domains.exercise.dto.ExerciseDto;
import com.b.flog_backend.domains.exercise.dto.ExerciseRoutineDto;
import com.b.flog_backend.domains.exercise.dto.RoutineDto;
import com.b.flog_backend.domains.exercise.mapper.RoutineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutineService {

    private final RoutineMapper routineMapper;

    @Transactional
    public void createRoutineAndExercises(ExerciseRoutineDto exerciseRoutineDto, int userId) {
        RoutineDto routineDto = new RoutineDto();
        routineDto.setUserId(userId);
        routineDto.setRoutineName(exerciseRoutineDto.getRoutineName());
        routineMapper.insertRoutine(routineDto);

        int routineId = routineDto.getId();
        List<ExerciseDto> exercises = exerciseRoutineDto.getExercises();

        if (exercises != null && !exercises.isEmpty()) {
            for (ExerciseDto exercise : exercises) {
                exercise.setUserId(userId);
                exercise.setRoutineId(routineId);
            }
            routineMapper.insertExercises(exercises);
        }
    }
}
