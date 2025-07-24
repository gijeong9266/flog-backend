package com.b.flog_backend.domains.exercise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.b.flog_backend.domains.exercise.dto.ExerciseDto;
import com.b.flog_backend.domains.exercise.service.ExerciseServiceImpl;

import com.b.flog_backend.domains.exercise.dto.ExerciseLogRequestDto;

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

        List<ExerciseDto> exerciseList = exerciseService.getExerciseLog(userId, logDate);
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

    @PostMapping("/inputExerciseLog")
    public Map<String, Object> addExerciseLog(Authentication authentication, @RequestBody ExerciseLogRequestDto payload) {
        Map<String, Object> map = new HashMap<>();
        int userId = (int) authentication.getPrincipal();

        exerciseService.addFullExerciseLog(payload, userId);

        map.put("result", "success");
        return map;
    }

}
