package com.korit.springboot.controller;

import com.korit.springboot.dto.ReqProductDto;
import com.korit.springboot.dto.RequestStudyInsertDto;
import com.korit.springboot.mapper.ProductMapper;
import com.korit.springboot.mapper.StudyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    private StudyMapper studyMapper;

//    @PostMapping("/mybatis/study")
//    public ResponseEntity<?> insert(@RequestBody Map<String, Object> data) {
//        studyMapper.insert((String) data.get("name"), (Integer)data.get("age"));
//        return ResponseEntity.ok().build();
//    }

    @PostMapping("/mybatis/study")
        public ResponseEntity<?> insert(@RequestBody RequestStudyInsertDto dto) {
        studyMapper.insert(dto.getName(), dto.getAge());
        return ResponseEntity.ok().build();
    }

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/mybatis/product")
    public ResponseEntity<?> insert(@RequestBody ReqProductDto dto) {
        productMapper.insert(dto.getProductName(), dto.getProductSize(), dto.getProductPrice());
        return ResponseEntity.ok().build();
    }

}
