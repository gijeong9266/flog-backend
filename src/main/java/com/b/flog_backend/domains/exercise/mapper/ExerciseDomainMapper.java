package com.b.flog_backend.domains.exercise.mapper;

import com.b.flog_backend.domains.exercise.dto.ExerciseDto;
import com.b.flog_backend.domains.exercise.dto.ExerciseLogRequestDto;
import com.b.flog_backend.domains.exercise.dto.ExercisePayloadDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class ExerciseDomainMapper {

    public ExerciseDto toExerciseDto(ExercisePayloadDto payload, ExerciseLogRequestDto request, int userId) {
        ExerciseDto dto = new ExerciseDto();
        dto.setUserId(userId);
        dto.setExerciseName(payload.getExerciseName());
        dto.setSector(payload.getSector());
        dto.setLogDate(LocalDate.parse(request.getLogDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        dto.setLogTime(LocalTime.parse(request.getLogTime(), DateTimeFormatter.ofPattern("HH:mm")));
        dto.setLoggedExercise(true);
        return dto;
    }
}
