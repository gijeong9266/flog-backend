package com.b.flog_backend.domains.goal.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ParticipationDto {
    private int id;
    private int userId;
    private int challengeId;
    private String isCanceled; // 'N' or 'Y'
    private LocalDateTime cancelAt;
    private int refundedPoint;
    private String refundStatus; // 'p', 'r', 'f'
    private LocalDateTime joinedAt;
}
