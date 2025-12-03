package com.korit.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestDataController {

    // GET /req/data 메서드명: reqGet

    // Get 요청 파라미터 받는 방법 1
    @GetMapping("/req/data1")
    public ResponseEntity<Map<String, String >> reqGet1(HttpServletRequest request) {
        String name = request.getParameter("a");
        int age = Integer.parseInt(request.getParameter("b"));
        System.out.println("data1: " + name);
        System.out.println("data1: " + age);
        return ResponseEntity.ok().build();
    }

    // Get 요청 파라미터 받는 방법 2
    @GetMapping("/req/data2")
    public ResponseEntity<Map<String, String >> reqGet2(@RequestParam("a") String name, @RequestParam("b") int age) {
        System.out.println("data2: " + name);
        System.out.println("data2: " + age);
        return ResponseEntity.ok().build();
    }

}
