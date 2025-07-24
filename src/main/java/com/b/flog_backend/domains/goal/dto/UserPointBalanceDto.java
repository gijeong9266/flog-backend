package com.b.flog_backend.domains.goal.dto;


import lombok.Data;

@Data
public class UserPointBalanceDto {
    private int id;
    private int userId;
    private int balance;
}
