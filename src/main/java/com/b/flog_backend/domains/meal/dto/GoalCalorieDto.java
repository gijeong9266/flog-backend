package com.b.flog_backend.domains.meal.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class GoalCalorieDto {
    private int id;
    private int userId;
    private int goalCalorie;
    private LocalDateTime createdAt;
}
