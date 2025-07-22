package com.b.flog_backend.common.controller;

import com.b.flog_backend.common.request.UserRequest;
import com.b.flog_backend.common.request.LoginRequest;
import com.b.flog_backend.common.model.User;
import com.b.flog_backend.common.service.UserService;
import com.b.flog_backend.common.security.JwtUtil;
import com.b.flog_backend.common.response.ApiResponse;
import com.b.flog_backend.common.response.LoginResponse;
import com.b.flog_backend.common.response.UserInfoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Void>> register(@RequestBody UserRequest userRequest) {

        if (userService.findByAccountName(userRequest.getAccountName()) != null) {
            return ResponseEntity.status(400).body(new ApiResponse<Void>(false, "이미 존재하는 계정명입니다.", null));
        }

        User user = new User();
        user.setAccountName(userRequest.getAccountName());
        user.setPassword(userRequest.getPassword());
        user.setNickname(userRequest.getNickname());
        user.setEmail(userRequest.getEmail());
        user.setGender(userRequest.getGender());
        user.setBirth(userRequest.getBirth());
        user.setPhone(userRequest.getPhone());
        userService.register(user);
        return ResponseEntity.ok(new ApiResponse<Void>(true, "회원가입 성공", null));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.findByAccountName(loginRequest.getAccountName());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(401).body(new ApiResponse<>(false, "아이디 또는 비밀번호가 올바르지 않습니다.", null));
        }
        String token = jwtUtil.generateToken(user.getId());
        UserInfoDto userInfo = new UserInfoDto(
            user.getId(), 
            user.getNickname(), 
            user.getImg()
            // user.getImg() != null ? user.getImg() : "default.png"  - 우린 이런방식 아닌데 , 유저 프로필 등록하는 방식이면 고려
        );
        return ResponseEntity.ok(new LoginResponse(true, token, userInfo)); // 닉네임 보내던것 -> 유저정보로 변경
    }

    @GetMapping("/verify-token")
    public ResponseEntity<ApiResponse<UserInfoDto>> verifyToken(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        try {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return ResponseEntity.status(401).body(new ApiResponse<>(false, "Authorization 헤더가 없거나 형식이 올바르지 않습니다.", null));
            }
            String token = authHeader.substring(7);
            boolean isValid = jwtUtil.validateToken(token);

            if (isValid) {
                Integer userId = jwtUtil.getUserId(token);
                User user = userService.findById(userId);
                if (user == null) {
                    return ResponseEntity.status(404).body(new ApiResponse<>(false, "사용자를 찾을 수 없습니다.", null));
                }
                UserInfoDto userInfo = new UserInfoDto(
                    user.getId(), 
                    user.getNickname(), 
                    user.getImg()
                );
                return ResponseEntity.ok(new ApiResponse<UserInfoDto>(true, null, userInfo));
            } else {
                return ResponseEntity.status(401).body(new ApiResponse<>(false, "토큰이 유효하지 않습니다.", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(401).body(new ApiResponse<>(false, "토큰 검증 중 오류가 발생했습니다.", null));
        }
    }
}
