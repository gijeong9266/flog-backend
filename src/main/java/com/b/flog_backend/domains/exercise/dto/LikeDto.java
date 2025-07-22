package com.b.flog_backend.domains.exercise.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LikeDto {
    private int id;
    private int userId;
    private int photoId;
    private LocalDateTime createdAt;
}
