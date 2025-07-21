package com.b.flog_backend.common.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String accountName;
    private String password;
}
