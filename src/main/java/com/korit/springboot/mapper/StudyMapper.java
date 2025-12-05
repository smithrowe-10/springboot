package com.korit.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyMapper {
    int insert(@Param("name") String name,@Param("age") int age);
                // study #{name}와 @Param("name")의 값이 맞아야됨

    List<String> findAllName();

}
