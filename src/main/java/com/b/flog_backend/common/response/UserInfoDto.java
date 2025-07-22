package com.b.flog_backend.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDto {
    private int id;
    private String nickname;
    private String img;
}
