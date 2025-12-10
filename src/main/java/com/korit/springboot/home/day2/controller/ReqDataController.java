package com.korit.springboot.home.day2.controller;

import com.korit.springboot.home.day2.dto.ReqDataDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ReqDataController {

    @GetMapping("/req/home/{id}/question")
    public ResponseEntity<?> getQ(
            @PathVariable int id,
            @Valid ReqDataDto dto) {
        System.out.println(id);
        System.out.println(dto.getName());
        System.out.println(dto.getAge());
        System.out.println(dto.getAddress());
        return ResponseEntity.ok().build();
    }

}
