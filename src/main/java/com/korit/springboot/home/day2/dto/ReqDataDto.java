package com.korit.springboot.home.day2.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqDataDto {

    @NotBlank
    private String name;

    private Integer age;

    @NotBlank
    private String address;

}
