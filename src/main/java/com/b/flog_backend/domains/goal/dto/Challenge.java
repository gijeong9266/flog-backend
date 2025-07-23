package com.b.flog_backend.domains.goal.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Challenge {
    private int id;
    private int creatorId;
    private String title;
    private String content;
    private int capacity;
    private String img;
    private LocalDate startDate;
    private LocalDate endDate;
    private int feePoint;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String isDeleted; // 'N' or 'Y'
    private LocalDateTime deletedAt;
}
