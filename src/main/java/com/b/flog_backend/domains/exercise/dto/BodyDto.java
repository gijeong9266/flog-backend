package com.b.flog_backend.domains.exercise.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BodyDto {
    private int id;
    private int userId;
    private Double weight;
    private Double bodyFatPercentage;
    private Double skeletalMuscleMass;
    private LocalDateTime createdAt;
}
