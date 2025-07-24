package com.b.flog_backend.domains.goal.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AuthCheckDto {
    private int id;
    private int partId;
    private String img;
    private String content;
    private LocalDate checkDate;
    private LocalDateTime checkedAt;
}
