package com.b.flog_backend.domains.goal.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChallengeHeart {
    private int id;
    private int userId;
    private int challengeId;
    private LocalDateTime likedAt;
}
