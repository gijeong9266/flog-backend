package com.b.flog_backend.domains.exercise.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class commentDto {
    private int id;
    private int userId;
    private int photoId;
    private String content;
    private LocalDateTime createdAt;
}
