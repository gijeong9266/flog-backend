package com.b.flog_backend.domains.exercise.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b.flog_backend.domains.exercise.dto.BodyDto;
import com.b.flog_backend.domains.exercise.service.BodyServiceImpl;

@RestController
@RequestMapping("/api/exercise")
@CrossOrigin(origins= "http://localhost:5173")
public class BodyController {
    @Autowired
    private BodyServiceImpl bodyService;

    @PostMapping("/bodyInfo")
    public Map<String, Object> createBodyInfo(@RequestBody BodyDto bodyDto, @AuthenticationPrincipal Integer userId){
        Map<String, Object> map = new HashMap<>();
        bodyDto.setUserId(userId);
        bodyService.insertBodyInfo(bodyDto);
        map.put("result", "success");
        return map;
    }

}
