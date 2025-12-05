package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {
    int insertProduct(@Param("product_name") String productName,
                      @Param("product_size") String productSize,
                      @Param("product_price") int productPrice);

    List<String> findAllName();
    List<Map<String, Object>> findAll();

}

// 만드는 순서 1 Mapper