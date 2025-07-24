package com.b.flog_backend.domains.goal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b.flog_backend.domains.goal.dto.ChallengeDto;
import com.b.flog_backend.domains.goal.mapper.ChallengeMapper;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeMapper challengeMapper;

    // 전체 챌린지 목록 조회 기능 구현
    public List<ChallengeDto> getAllChallenges() {
        return challengeMapper.getAllChallenges();
    }

    // 챌린지 상세 조회
    public ChallengeDto getChallengeById(int id) {
        return challengeMapper.getChallengeById(id);
    }

    // 챌린지 생성
    public void createChallenge(ChallengeDto challengeDto) {
        challengeMapper.insertChallenge(challengeDto);
    }

    // 챌린지 수정
    public void updateChallenge(ChallengeDto challengeDto) {
        challengeMapper.updateChallenge(challengeDto);
    }

    // 챌린지 삭제
    public void deleteChallenge(int id) {
        challengeMapper.deleteChallenge(id);
    }   

}
