package com.b.flog_backend.domains.exercise.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b.flog_backend.domains.exercise.dto.ExerciseDto;
import com.b.flog_backend.domains.exercise.service.ExerciseServiceImpl;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {
    @Autowired
    private ExerciseServiceImpl exerciseService;

    // 유저 아이디, 날짜별 조회
    @GetMapping("/exerciseLog")
    public Map<String, Object> getExerciseLog(@RequestParam("userId") int userId, @RequestParam("logDate") String logDate){
        Map<String, Object> map = new HashMap();

        List<ExerciseDto> exerciseList = exerciseService.getExerciseLog(userId, logDate);
        map.put("result", exerciseList);
        
        return map;
    }

}
