package com.b.flog_backend.domains.meal.service;

import java.time.LocalDate;
import java.util.List;

import com.b.flog_backend.domains.meal.dto.FoodDto;
import com.b.flog_backend.domains.meal.dto.MealDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b.flog_backend.domains.meal.dto.TodayCalorieDto;
import com.b.flog_backend.domains.meal.mapper.CalorieMapper;
import com.b.flog_backend.domains.meal.response.TotalCalorie;

@Service
public class CalorieService {

    @Autowired
    private CalorieMapper calorieMapper;

    public void insertTodayCalorie(int userId) {

        TodayCalorieDto todayCalorieDto = new TodayCalorieDto(userId);

        calorieMapper.insertTodayCalorie(todayCalorieDto);
        int todayCalorieId = todayCalorieDto.getId();
        System.out.println("TodayCalorie ID: " + todayCalorieId);

        List<String> mealTypes = List.of("아침", "점심", "저녁", "기타");
        for (String type : mealTypes) {
            System.out.println("Inserting meal of type: " + type);
            calorieMapper.insertMeal(new MealDto(todayCalorieId, type));
        }

        return;
    }

    public void insertFood(FoodDto foodDto) {
        calorieMapper.insertFood(foodDto);
    }

    public List<TodayCalorieDto> findTodayCalorieListByUserId(int userId) {
        return calorieMapper.findTodayCalorieListByUserId(userId);
    }

    public TodayCalorieDto findTodayCalorieByUserId(int userId) {
        return calorieMapper.findTodayCalorieByUserId(userId);
    }

    public TodayCalorieDto findTodayCalorieByUserIdAndDate(int userId, LocalDate date) {
        return calorieMapper.findTodayCalorieByUserIdAndDate(userId, date);
    }

    public List<TotalCalorie> findTotalCalorieByTodayCalorieId(int todayCalorieId) {
        TodayCalorieDto todayCalorieDto = calorieMapper.findTodayCalorieById(todayCalorieId);
        return calorieMapper.findTotalCalorieByTodayCalorie(todayCalorieDto);
    }
}
