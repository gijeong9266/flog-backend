package com.b.flog_backend.common.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRequest {
    private String accountName;
    private String password;
    private String nickname;
    private String email;
    private String gender;
    private LocalDate birth;
    private String phone;
}
