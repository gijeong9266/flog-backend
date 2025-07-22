package com.b.flog_backend.domains.exercise.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FollowDto {
    private int id;
    private int followerId;
    private int followeeId;
    private LocalDateTime createdAt;
}
