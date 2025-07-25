package com.b.flog_backend.domains.exercise.dto;

import lombok.Data;

import java.util.List;

@Data
public class ExerciseRoutineDto {
    private String routineName;
    private List<ExerciseDto> exercises;
}
