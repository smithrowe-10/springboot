package com.korit.springboot.dto;

import lombok.Data;

@Data
public class ReqProductDto {

    private String productName;
    private String productSize;
    private Integer productPrice;

}
