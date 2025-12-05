package com.korit.springboot.controller;

import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// 1
@RestController
// CSR은 백엔드에서 무조건 데이터 응답만 함 그걸 나타내는게 RestController라고함
// 반면 SSR은 HTML로 응답을 주기때문에 그냥 Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<Map<String, Integer>> create(@Valid @RequestBody CreateUserReqDto dto){
        userService.duplicatedUsername(dto.getUsername());
        int createdUserId = userService.createUser(dto);
        return ResponseEntity.ok(Map.of("createdUserId", createdUserId));
    }

}