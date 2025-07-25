package com.b.flog_backend.domains.meal.mapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.b.flog_backend.domains.meal.dto.FoodDto;
import com.b.flog_backend.domains.meal.dto.GoalCalorieDto;
import com.b.flog_backend.domains.meal.dto.MealDto;
import com.b.flog_backend.domains.meal.dto.TodayCalorieDto;
import com.b.flog_backend.domains.meal.response.TotalCalorie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CalorieMapper {
    void insertTodayCalorie(TodayCalorieDto todayCalorieDto);
    void insertMeal(MealDto mealDto);
    void insertFood(FoodDto foodDto);
    List<TodayCalorieDto> findTodayCalorieListByUserId(int userId);
    TodayCalorieDto findTodayCalorieByUserId(int userId);
    TodayCalorieDto findTodayCalorieByUserIdAndDate(@Param("userId") int userId, @Param("date") LocalDate date);
    List<TotalCalorie> findTotalCalorieByTodayCalorie(TodayCalorieDto todayCalorieDto);
    TodayCalorieDto findTodayCalorieById(int todayCalorieId);
    
    void insertGoalCalorie(GoalCalorieDto goalCalorieDto);
    void updateGoalCalorie(GoalCalorieDto goalCalorieDto);
    Integer selectGoalCalorieByUserId(int userId);
    List<FoodDto> findFoodListByMealId(int mealId);
    void updateFood(FoodDto foodDto);
    void deleteFood(int id);
    List<Map<String, Object>> findCalorie(@Param("userId")int userId);
    public List<Map<String, Object>> findfoodListByDate(@Param("userId") int userId, @Param("date") LocalDate date);
    public Integer findGoalCalorieByDate(@Param("userId") int userId, @Param("date") LocalDate date);
}
