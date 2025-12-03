package com.korit.springboot.controller;

import com.korit.springboot.dto.RespJsonDto;
import com.korit.springboot.dto.RespJsonDto2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ResponseDataController {

    // 응답 데이터 - 문자열
    @GetMapping("/resp/data")
    public ResponseEntity<String> getString() {
        return ResponseEntity.ok("문자열 응답");
    }

    // 응답 데이터 - MAP
    @GetMapping("/resp/data2")
    public ResponseEntity<Map<String, Object>> getMap() {
        return ResponseEntity.ok(Map.of("key1", "value1", "key2", "value2"));
    }

    // 응답 데이터 - LIST
    @GetMapping("/resp/data3")
    public ResponseEntity<List<?>> getList() {
//        return ResponseEntity.ok(List.of("a", "b", "c"));
        return ResponseEntity.ok(List.of(1, 2, 3, 4));
    }

    // 응답 데이터 - DTO
    @GetMapping("/resp/data4")
    public ResponseEntity<RespJsonDto> getDto() {
        RespJsonDto dto = new RespJsonDto();
        dto.setName("서민재");
        dto.setEmail("smj0418@gmail.com");
        dto.setRespJsonDto2(new RespJsonDto2());
        return ResponseEntity.ok(dto);
    }

}
