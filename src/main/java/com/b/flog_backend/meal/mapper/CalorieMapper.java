package com.b.flog_backend.meal.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.b.flog_backend.meal.dto.FoodDto;
import com.b.flog_backend.meal.dto.MealDto;
import com.b.flog_backend.meal.dto.TodayCalorieDto;
import com.b.flog_backend.meal.response.TotalCalorie;

@Mapper
public interface CalorieMapper {
    void insertTodayCalorie(TodayCalorieDto todayCalorieDto);
    void insertMeal(MealDto mealDto);
    void insertFood(FoodDto foodDto);
    List<TodayCalorieDto> findTodayCalorieListByUserId(int userId);
    TodayCalorieDto findTodayCalorieByUserIdAndDate(@Param("userId") int userId, @Param("date") LocalDate date);
    List<TotalCalorie> findTotalCalorieByTodayCalorie(TodayCalorieDto todayCalorieDto);
    TodayCalorieDto findTodayCalorieById(int todayCalorieId);
}
