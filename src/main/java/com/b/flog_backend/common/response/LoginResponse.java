package com.b.flog_backend.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private boolean success;
    private String token;
    // private String nickname;
    private UserInfoDto userInfo;
}
