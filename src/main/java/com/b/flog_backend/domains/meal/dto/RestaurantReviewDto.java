package com.b.flog_backend.domains.meal.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RestaurantReviewDto {
    private int id;
    private int userId;
    private int placeId;
    private Float rating;
    private String content;
    private LocalDateTime createdAt;
}