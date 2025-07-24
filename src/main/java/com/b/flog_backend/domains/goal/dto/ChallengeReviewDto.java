package com.b.flog_backend.domains.goal.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChallengeReviewDto {
    private int id;
    private int partId;
    private int rating;
    private String content;
    private LocalDateTime createdAt;
}
