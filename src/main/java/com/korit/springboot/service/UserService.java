package com.korit.springboot.service;

import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
//  중간에 오류가 생기면 지금까지의 과정을 커밋하지 마라   (rollbackFor = Exception.class) 어떤 오류가 터지든 롤백해라
    public void createUser(CreateUserReqDto dto) {
        userMapper.insert(dto.toEntity());
    }
}
