package com.b.flog_backend.domains.exercise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b.flog_backend.domains.exercise.dto.ExerciseLogRequestDto;
import com.b.flog_backend.domains.exercise.dto.ExercisePayloadDto;
import com.b.flog_backend.domains.exercise.service.ExerciseServiceImpl;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
    @Autowired
    private ExerciseServiceImpl exerciseService;

    // 유저 아이디, 날짜별 조회
    @GetMapping("/exerciseLog")
    public Map<String, Object> getExerciseLog(Authentication authentication, @RequestParam("logDate") String logDate){
        Map<String, Object> map = new HashMap();
        int userId = (int) authentication.getPrincipal();

        List<ExercisePayloadDto> exerciseList = exerciseService.getExerciseLog(userId, logDate);
        map.put("result", exerciseList);
        
        return map;
    }

    // 달력에 운동유무 표시
    @GetMapping("/recordedDate")
    public Map<String, Object> getRecordedDates(Authentication authentication){
        Map<String, Object> map = new HashMap<>();
        int userId = (int) authentication.getPrincipal();
        List<String> list = exerciseService.getRecordedDates(userId);

        map.put("result", list);

        return map;
    }

    // 유저별 루틴 리스트 불러오기
    @GetMapping("/getRoutineList")
    public Map<String, Object> getRoutineList(@AuthenticationPrincipal Integer userId){
        Map<String, Object> map = new HashMap<>();
        map.put("result", exerciseService.getRoutineDtoList(userId));
        return map;
    }




    // 운동 및 세트 저장
    @PostMapping("/inputExerciseLog")
    public Map<String, Object> addExerciseLog(@AuthenticationPrincipal Integer userId, @RequestBody ExerciseLogRequestDto payload) {
        Map<String, Object> map = new HashMap<>();

        exerciseService.addFullExerciseLog(payload, userId);

        map.put("result", "success");
        return map;
    }



}
