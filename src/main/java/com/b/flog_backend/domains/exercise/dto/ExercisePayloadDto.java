package com.b.flog_backend.domains.exercise.dto;

import lombok.Data;
import java.util.List;

@Data
public class ExercisePayloadDto {
    private String exerciseName;
    private String sector;
    private List<ExerciseSetDto> sets;
}
