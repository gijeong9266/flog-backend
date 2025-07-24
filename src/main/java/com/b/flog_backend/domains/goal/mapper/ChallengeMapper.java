package com.b.flog_backend.domains.goal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.b.flog_backend.domains.goal.dto.ChallengeDto;

@Mapper
public interface ChallengeMapper {

    // 전체 챌린지 목록 조회
    List<ChallengeDto> getAllChallenges();

    // 챌린지 상세 조회
    ChallengeDto getChallengeById(int id);

    // 챌린지 생성, 수정, 삭제
    void insertChallenge(ChallengeDto challengeDto);

    void updateChallenge(ChallengeDto challengeDto);

    void deleteChallenge(int id);

}
