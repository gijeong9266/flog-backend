package com.b.flog_backend.domains.goal.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserPointLog {
    private int id;
    private int userId;
    private int challengeId;
    private String status; // CHARGE, USE, CANCEL, REFUND
    private int pointChange;
    private LocalDateTime createdAt;
}
