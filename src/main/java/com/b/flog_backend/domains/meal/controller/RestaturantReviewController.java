package com.b.flog_backend.domains.meal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b.flog_backend.domains.meal.dto.RestaurantReviewDto;
import com.b.flog_backend.domains.meal.service.RestaurantReviewService;

@RestController
@RequestMapping("/meal/restaurantReview")
public class RestaturantReviewController {

    @Autowired
    private RestaurantReviewService restaurantReviewService;

    @PostMapping("insertRestaurantReview")
    public void insertRestaurantReview(@RequestBody RestaurantReviewDto restaurantReviewDto) {
        restaurantReviewService.insertRestaurantReview(restaurantReviewDto);
    }

    @PutMapping("updateRestaurantReview")
    public void updateRestaurantReview(@RequestBody RestaurantReviewDto restaurantReviewDto) {
        restaurantReviewService.updateRestaurantReview(restaurantReviewDto);
    }

    @DeleteMapping("deleteRestaurantReview")
    public void deleteRestaurantReview(@RequestParam("id") int id) {
        restaurantReviewService.deleteRestaurantReview(id);
    }
}
