package com.b.flog_backend.domains.goal.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChallengeSearchMapper {

    // 유저id 기반으로 해당 챌린지가 있는지 조회
    int isChallengeExistsByUserId(int userId, int challengeId);
}
