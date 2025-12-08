package com.korit.springboot.service;

import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.dto.SignupReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.exception.DuplicatedException;
import com.korit.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)

    public int createUser(SignupReqDto dto) {
        UserEntity userEntity = dto.toEntity();
        userMapper.insert(userEntity);
        return userEntity.getUserId();

    }

    public void duplicatedUsername(String username){
        UserEntity foundUser = userMapper.findUserByUsername(username);

        if (foundUser != null) {
            throw new DuplicatedException("username", "이미 존재하는 사용자이름입니다.");
        }
    }
}
