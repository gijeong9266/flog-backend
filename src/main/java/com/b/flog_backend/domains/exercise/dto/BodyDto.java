package com.b.flog_backend.domains.exercise.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BodyDto {
    private int id;
    private int userId;
    private Double weight;
    private Double fat;
    private Double muscle;
    private LocalDate recordDate;
    private LocalDateTime createdAt;
}
