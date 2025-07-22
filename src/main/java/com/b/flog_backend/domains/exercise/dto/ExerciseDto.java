package com.b.flog_backend.domains.exercise.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExerciseDto {
    private int id;
    private int routineId;
    private int userId;
    private String sector;
    private String exerciseName;
    private LocalDateTime createdAt;
}
