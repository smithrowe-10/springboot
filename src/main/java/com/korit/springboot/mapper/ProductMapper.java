package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    int insertProduct(@Param("product_name") String productName, @Param("product_size") String productSize, @Param("product_price") int productPrice);
    // study #{name}와 @Param("name")의 값이 맞아야됨
}

// 만드는 순서 1 Mapper