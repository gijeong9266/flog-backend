package com.b.flog_backend.domains.exercise.dto;

import lombok.Data;
import java.util.List;

@Data
public class ExerciseLogRequestDto {
    private String logDate;
    private String logTime;
    private List<ExercisePayloadDto> exercises;
}
