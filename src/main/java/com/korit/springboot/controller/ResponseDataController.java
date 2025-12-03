package com.korit.springboot.controller;

import com.korit.springboot.dto.RespJsonDto;
import com.korit.springboot.dto.RespJsonDto2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;


import java.nio.charset.StandardCharsets;
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

    @GetMapping("/resp/data5")
    public ResponseEntity<Resource> download(@RequestParam String filename) {
        Resource resource = new ClassPathResource("static/" + filename);
        System.out.println(resource);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + filename + "\"")
                .body(resource);
    }

    @GetMapping("/resp/data6")
    public ResponseEntity<Resource> downloadUTF8(@RequestParam String filename) {
        Resource resource = new ClassPathResource("static/" + filename);
        System.out.println(resource);

        String contentDisposition = ContentDisposition.builder("attachment")
                .filename(filename, StandardCharsets.UTF_8)
                .build().toString();

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
//               contentDisposition 이 "attachment; filename=\"" + filename + "\""
                .body(resource);
    }
}
