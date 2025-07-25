package com.b.flog_backend.domains.exercise.dto;

import java.util.List;

import lombok.Data;

@Data
public class ExercisePayloadDto {
    private String exerciseName;
    private String sector;
    private String logDate;
    private String logTime;
    private List<ExerciseSetDto> sets;
}
