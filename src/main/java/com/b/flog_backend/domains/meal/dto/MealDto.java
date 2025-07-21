package com.b.flog_backend.domains.meal.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MealDto {
    private int id;
    private int todayCalorieId;
    private String type;
    private LocalDateTime createdAt;

    public MealDto(int todayCalorieId, String type) {
        this.todayCalorieId = todayCalorieId;
        this.type = type;
    }
}
