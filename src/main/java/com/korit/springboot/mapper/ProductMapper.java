package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    int insert(@Param("product_name") String productName, @Param("product_size") String productSize, @Param("product_price") int productPrice);
    // study #{name}와 @Param("name")의 값이 맞아야됨
}
