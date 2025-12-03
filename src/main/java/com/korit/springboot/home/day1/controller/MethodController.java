package com.korit.springboot.home.day1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/method")
@RestController
// CSR 에서 쓰는 방식으로 백엔드에서 데이터만 처리할때 RestController을 사용한다
public class MethodController {

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("풋이야");
    }

    @PostMapping
    public ResponseEntity<String> post() {
        return ResponseEntity.ok("포스트야");
    }

}
