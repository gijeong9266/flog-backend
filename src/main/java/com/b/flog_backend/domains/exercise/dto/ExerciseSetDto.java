package com.b.flog_backend.domains.exercise.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExerciseSetDto {
    private int id;
    private int exerciseId;
    @JsonProperty("set_number")
    private int setNumber;
    private Double intensity;
    private int reps;
    private LocalDateTime createdAt;
}
