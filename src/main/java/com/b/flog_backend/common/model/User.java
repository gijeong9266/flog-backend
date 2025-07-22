package com.b.flog_backend.common.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String accountName;
    private String password;
    private String nickname;
    private String email;
    private String gender;
    private LocalDate birth;
    private String phone;
    private String img;
    private LocalDateTime createdAt;
}
