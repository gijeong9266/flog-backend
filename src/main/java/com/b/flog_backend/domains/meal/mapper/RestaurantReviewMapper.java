package com.b.flog_backend.domains.meal.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.b.flog_backend.domains.meal.dto.RestaurantReviewDto;

@Mapper
public interface RestaurantReviewMapper {
    public void insertRestaurantReview(RestaurantReviewDto restaurantReviewDto);
    public void updateRestaurantReview(RestaurantReviewDto restaurantReviewDto);
    public void deleteRestaurantReview(int id);
}
