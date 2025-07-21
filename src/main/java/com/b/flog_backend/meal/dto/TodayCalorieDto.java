package com.b.flog_backend.meal.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TodayCalorieDto {
    private int id;
    private int userId;
    private LocalDate date;
    private LocalDateTime createdAt;

    public TodayCalorieDto(int userId) {
        this.userId = userId;
    }
}
