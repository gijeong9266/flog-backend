package com.b.flog_backend.domains.exercise.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PhotoDto {
    private int id;
    private int userId;
    private String image;
    private String description;
    private String isPublic;
    private LocalDateTime createdAt;
}
