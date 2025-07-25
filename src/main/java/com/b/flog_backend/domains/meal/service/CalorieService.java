package com.b.flog_backend.domains.meal.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.b.flog_backend.domains.meal.dto.FoodDto;
import com.b.flog_backend.domains.meal.dto.GoalCalorieDto;
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

    public void insertGoalCalorie(GoalCalorieDto goalCalorieDto) {
        calorieMapper.insertGoalCalorie(goalCalorieDto);
    }

    public void updateGoalCalorie(GoalCalorieDto goalCalorieDto) {
        calorieMapper.updateGoalCalorie(goalCalorieDto);
    }

    public Integer selectGoalCalorieByUserId(int userId) {
        return calorieMapper.selectGoalCalorieByUserId(userId);
    }

    public List<FoodDto> findFoodListByMealId(int mealId) {
        return calorieMapper.findFoodListByMealId(mealId);
    }

    public void updateFood(FoodDto foodDto) {
        calorieMapper.updateFood(foodDto);
    }

    public void deleteFood(int id) {
        calorieMapper.deleteFood(id);
    }

    public List<Map<String, Object>> findCalorie(int userId) {
        return calorieMapper.findCalorie(userId);
    }
    
    public List<Map<String, Object>> findfoodListByDate(int userId, LocalDate date) {
        return calorieMapper.findfoodListByDate(userId, date);
    }

    public int findGoalCalorieByDate(int userId, LocalDate date) {
        Integer goalCalorie = calorieMapper.findGoalCalorieByDate(userId, date);
        if (goalCalorie == null) {
            return 1800;
        }
        return goalCalorie;
    }
}
