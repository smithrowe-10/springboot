package com.korit.springboot.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// 1
@RestController
// CSR은 백엔드에서 무조건 데이터 응답만 함 그걸 나타내는게 RestController라고함
// 반면 SSR은 HTML로 응답을 주기때문에 그냥 Controller
public class UserController {

    private String username = "test12";
    private String password = "1234";

    // servlet 같은 경우 class위에 URL을 달았지만 springboot는 클래스 내부 메서드 위에 URL을 달기때문에 한 클래스에 URL 여러개 할수있음
    @GetMapping("/info1")
    public ResponseEntity<String> printInfo1() {
        return ResponseEntity.ok("USERController!!!");
    }

    @GetMapping("/info2")
    public ResponseEntity<String> printInfo2() {
        return ResponseEntity.ok("USERController!!!");
    }

//    @GetMapping("/users")
//    public Map<String,String> getUser(HttpServletResponse response) {
//        response.setStatus(400);
//        response.setContentType("application/json");
//        return Map.of("username", username, "password", password);
//    }

    @GetMapping("/users")
    public ResponseEntity<Map<String,String>> getUser(HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("username", username, "password", password));
    }
//    ResponseEntity<Map<String,String>> 이런식으로 하면 JSON으로 보내짐



}