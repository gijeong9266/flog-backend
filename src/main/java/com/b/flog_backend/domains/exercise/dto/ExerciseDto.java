package com.b.flog_backend.domains.exercise.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;

@Data
public class ExerciseDto {
    private int id;
    private int userId;
    private int routineId;
    private String sector;
    private String exerciseName;
    private LocalDate logDate;
    private LocalTime logTime;
    private boolean isLoggedExercise;
    private LocalDateTime createdAt;
}
