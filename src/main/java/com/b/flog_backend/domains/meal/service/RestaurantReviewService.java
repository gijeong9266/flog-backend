package com.b.flog_backend.domains.meal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b.flog_backend.domains.meal.dto.RestaurantReviewDto;
import com.b.flog_backend.domains.meal.mapper.RestaurantReviewMapper;

@Service
public class RestaurantReviewService {

    @Autowired
    private  RestaurantReviewMapper restaurantReviewMapper;

    public void insertRestaurantReview(RestaurantReviewDto restaurantReviewDto) {
        restaurantReviewMapper.insertRestaurantReview(restaurantReviewDto);
    }

    public void updateRestaurantReview(RestaurantReviewDto restaurantReviewDto) {
        restaurantReviewMapper.updateRestaurantReview(restaurantReviewDto);
    }

    public void deleteRestaurantReview(int id) {
        restaurantReviewMapper.deleteRestaurantReview(id);
    }
}
