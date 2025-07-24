package com.b.flog_backend.domains.goal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b.flog_backend.domains.goal.dto.ChallengeDto;
import com.b.flog_backend.domains.goal.service.ChallengeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("goal")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

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
    public void createChallenge(@RequestBody ChallengeDto challengeDto) {
        challengeService.createChallenge(challengeDto);
    }

    // 챌린지 수정
    @PostMapping("/challengeUpdate")
    public void updateChallenge(@RequestBody ChallengeDto challengeDto) {
        challengeService.updateChallenge(challengeDto);
    }

    // 챌린지 삭제
    @PostMapping("/challengeDelete")
    public void deleteChallenge(@RequestBody int id) {
        challengeService.deleteChallenge(id);
    }



    // 챌린지 좋아요
    // 챌린지 좋아요 기능 구현

    // 챌린지 좋아요 목록

    // 챌린지 검색

    // 챌린지 참여 목록

    // 챌린지 참여



}
