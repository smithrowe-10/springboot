package com.korit.springboot.controller;

import com.korit.springboot.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    private StudyMapper studyMapper;

    @PostMapping("/mybatis/study")
    public ResponseEntity<?> insert() {
        studyMapper.insert("배지훈", 18);
        return ResponseEntity.ok().build();
    }

}
