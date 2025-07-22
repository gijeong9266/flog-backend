package com.b.flog_backend.domains.exercise.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExerciseRecordDto {
    private int id;
    private int exerciseSetId;
    private String complete;
    private String memo;
    private LocalDateTime createdAt;
}
