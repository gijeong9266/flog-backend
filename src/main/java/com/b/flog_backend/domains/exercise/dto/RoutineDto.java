package com.b.flog_backend.domains.exercise.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RoutineDto {
    private int id;
    private int userId;
    private String routineName;
    private LocalDateTime createdAt;
}
