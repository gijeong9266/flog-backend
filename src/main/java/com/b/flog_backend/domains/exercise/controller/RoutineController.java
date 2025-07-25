package com.b.flog_backend.domains.exercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b.flog_backend.common.response.ApiResponse;
import com.b.flog_backend.domains.exercise.dto.ExerciseRoutineDto;
import com.b.flog_backend.domains.exercise.service.RoutineService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/exercise")
@RequiredArgsConstructor
public class RoutineController {

    private final RoutineService routineService;

    @PostMapping("/addRoutineAndExercises")
    public ResponseEntity<ApiResponse<Void>> createRoutineAndExercises(@RequestBody ExerciseRoutineDto exerciseRoutineDto, @AuthenticationPrincipal(expression = "userId") int userId) {
        routineService.createRoutineAndExercises(exerciseRoutineDto, userId);
        ApiResponse<Void> response = new ApiResponse<>(true, "Routine and exercises created successfully.", null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
