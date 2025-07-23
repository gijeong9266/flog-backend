package com.b.flog_backend.domains.meal.response;

import lombok.Data;

@Data
public class TotalCalorie {
    private int mealId;
    private String type;
    private int totalCalorie;
}
