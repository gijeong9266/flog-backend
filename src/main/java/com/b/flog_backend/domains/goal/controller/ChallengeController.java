package com.b.flog_backend.domains.goal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b.flog_backend.domains.goal.dto.ChallengeDto;
import com.b.flog_backend.domains.goal.service.ChallengeSearchService;
import com.b.flog_backend.domains.goal.service.ChallengeService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("goal")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private ChallengeSearchService challengeSearchService;

    // 전체 챌린지 목록 조회 기능 구현
    @GetMapping("/challengeList")
    public List<ChallengeDto> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    // 챌린지 상세 조회
    @GetMapping("/challengeDetail/{id}")
    public ChallengeDto getChallengeById(@PathVariable int id) {
        return challengeService.getChallengeById(id);
    }

    // 챌린지 생성
    @PostMapping("/challengeDetail")
    public ResponseEntity<Map<String, Object>> createChallenge(
            @AuthenticationPrincipal Integer userId,
            @RequestBody ChallengeDto challengeDto) {
        // 굳이 백엔드에서 개설자id와 토큰id 비교 검증코드 없는이유 : JWT 토큰에서 파싱한 값 → 신뢰 가능

        Boolean challengeExists = challengeSearchService.isChallengeExistsByUserId(userId, challengeDto.getId());
        if (challengeExists) {
            return ResponseEntity.status(400).body(Map.of(
                    "success", false,
                    "message", "이미 존재하는 챌린지입니다."));
        }

        challengeDto.setCreatorId(userId);
        challengeService.createChallenge(challengeDto);
        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "챌린지가 생성되었습니다."));
    }

    // 챌린지 수정
    @PostMapping("/challengeUpdate")
    public ResponseEntity<Map<String, Object>> updateChallenge(
            @AuthenticationPrincipal Integer userId,
            @RequestBody ChallengeDto challengeDto) {

        Boolean challengeExists = challengeSearchService.isChallengeExistsByUserId(userId, challengeDto.getId());
        if (!challengeExists) {
            return ResponseEntity.status(404).body(Map.of(
                    "success", false,
                    "message", "챌린지가 존재하지 않습니다."));
        }

        challengeDto.setCreatorId(userId);
        challengeService.updateChallenge(challengeDto);
        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "수정이 완료되었습니다."));
    }

    // 챌린지 삭제
    @PostMapping("/challengeDelete")
    public ResponseEntity<Map<String, Object>> deleteChallenge(
            @AuthenticationPrincipal Integer userId,
            @RequestBody int id) {

        Boolean challengeExists = challengeSearchService.isChallengeExistsByUserId(userId, id);

        if (!challengeExists) {
            return ResponseEntity.status(404).body(Map.of(
                    "success", false,
                    "message", "챌린지가 존재하지 않습니다."));
        }

        challengeService.deleteChallenge(id);
        return ResponseEntity.ok(Map.of(
                "success", true,
                "message", "삭제가 완료되었습니다."));
    }

    // 챌린지 좋아요
    // 챌린지 좋아요 기능 구현

    // 챌린지 좋아요 목록

    // 챌린지 검색

    // 챌린지 참여 목록

    // 챌린지 참여

}
