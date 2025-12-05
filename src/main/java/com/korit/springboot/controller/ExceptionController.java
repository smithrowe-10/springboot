package com.korit.springboot.controller;

import com.korit.springboot.dto.ValidErrorRespDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    // 특정 예외가 터지면 강제로 본인이 대신 응답하는 새끼
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> duplicatedException(SQLIntegrityConstraintViolationException e) {
        e.printStackTrace();
        return ResponseEntity.badRequest().body(e.getMessage());
                                            // 클라이언트한테 뭔 잘못을 했는지 깨닫게 해주기
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidErrorRespDto>> validException(MethodArgumentNotValidException e) {
//        Map<String, String> errorMap = new LinkedHashMap<>();
//
//        e.getFieldErrors().forEach(err -> {
//            errorMap.put(err.getField(), err.getDefaultMessage());
//        });

        List<ValidErrorRespDto> errors = e.getFieldErrors()
                .stream()
                .map(err -> new ValidErrorRespDto(err.getField(), err.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }
}
