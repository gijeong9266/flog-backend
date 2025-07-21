package com.b.flog_backend.meal.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b.flog_backend.meal.dto.TodayCalorieDto;
import com.b.flog_backend.meal.response.TotalCalorie;
import com.b.flog_backend.meal.service.CalorieService;

@RestController
@RequestMapping("/meal/calorie")
public class CalorieController {
    
    @Autowired
    private CalorieService calorieService;

    @PostMapping("/insertTodayCalorie")
    public TodayCalorieDto insertCalorie() {

        int userId = (int)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        TodayCalorieDto calorie = calorieService.findTodayCalorieByUserIdAndDate(userId, LocalDate.now());
        if (calorie != null) {
            return calorie; // 이미 오늘의 칼로리 정보가 존재하는 경우
        }

        calorieService.insertTodayCalorie(userId);

        return calorieService.findTodayCalorieByUserIdAndDate(userId, LocalDate.now());
    }

    @GetMapping("/findTodayCalorieListByUserId")
    public List<TodayCalorieDto> findTodayCalorieListByUserId(@RequestParam("userId") int userId) {
        return calorieService.findTodayCalorieListByUserId(userId);
    }

    @GetMapping("/findTotalCalorieByTodayCalorie")
    public List<TotalCalorie> findTotalCalorieByTodayCalorie(@RequestParam("todayCalorieId") int todayCalorieId) {
        return calorieService.findTotalCalorieByTodayCalorieId(todayCalorieId);
    }
}
