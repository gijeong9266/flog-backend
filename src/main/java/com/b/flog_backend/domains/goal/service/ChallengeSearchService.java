package com.b.flog_backend.domains.goal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b.flog_backend.domains.goal.mapper.ChallengeSearchMapper;

@Service
public class ChallengeSearchService {

    @Autowired
    private ChallengeSearchMapper challengeSearchMapper;

    // 유저id 기반으로 해당 챌린지가 있는지 조회
    public Boolean isChallengeExistsByUserId(int userId, int challengeId) {
        return challengeSearchMapper.isChallengeExistsByUserId(userId, challengeId) > 0;
    }

}
