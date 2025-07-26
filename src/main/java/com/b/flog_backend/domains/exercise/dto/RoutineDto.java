package com.b.flog_backend.domains.exercise.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RoutineDto {
    private int id;
    private int userId;
    private String routineName;
    private LocalDateTime createdAt;
    private List<ExerciseDto> exercises; // 운동 목록을 담을 필드 추가
}
