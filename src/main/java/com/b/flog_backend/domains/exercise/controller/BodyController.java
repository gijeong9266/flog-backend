package com.b.flog_backend.domains.exercise.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b.flog_backend.domains.exercise.dto.BodyDto;
import com.b.flog_backend.domains.exercise.service.BodyServiceImpl;

@RestController
@RequestMapping("/api/exercise")
@CrossOrigin(origins= "http://localhost:5173")
public class BodyController {
    @Autowired
    private BodyServiceImpl bodyService;

    // post
    @PostMapping("/bodyInfo")
    public Map<String, Object> createBodyInfo(@RequestBody BodyDto bodyDto){
        Map<String, Object> map = new HashMap<>();
        bodyService.insertBodyInfo(bodyDto);
        map.put("result", "success");
        return map;
    }




    // get
    @GetMapping("/bodyInfo")
    public Map<String, Object> getBodyInfo(@RequestParam ("userId") int userId) {
        Map<String, Object> map = new HashMap<>();
        
        BodyDto dto = bodyService.getBodyInfo(userId);
        map.put("result", "success");
        map.put("bodyInfo", dto);
        return map;
    }

}
