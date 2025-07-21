package com.b.flog_backend.meal.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FoodDto {
    private int id;
    private int mealId;
    private String name;
    private int calorie;
    private String imageAddress;
    private LocalDateTime createdAt;
}
