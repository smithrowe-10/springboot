package com.korit.springboot.exception;


import com.korit.springboot.dto.ValidErrorRespDto;
import lombok.Getter;

// 중복 예외처리
public class DuplicatedException extends RuntimeException{
    @Getter
    private ValidErrorRespDto validErrorRespDto;

    public DuplicatedException(String message, String fieldName) {
        super(message);
        this.validErrorRespDto = new ValidErrorRespDto(fieldName, message);
    }


}
