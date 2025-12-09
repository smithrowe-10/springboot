package com.korit.springboot.service;

import com.korit.springboot.dto.SigninReqDto;
import com.korit.springboot.dto.SignupReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.jwt.JwtTokenProvider;
import com.korit.springboot.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional(rollbackFor = Exception.class)
    public void signup(SignupReqDto dto) {
        UserEntity userEntity = dto.toEntity(passwordEncoder);
        userMapper.insert(userEntity);
    }

    public String signin(SigninReqDto dto) {
        final String username = dto.getUsername();
        final String password = dto.getPassword();
        final String defaultMessage = "사용자 정보를 확인하세요.";

        UserEntity foundUser = userMapper.findUserByUsername(username);
        if (Objects.isNull(foundUser)) {
            throw new UsernameNotFoundException(defaultMessage);
        }
        if (!passwordEncoder.matches(password, foundUser.getPassword())) {
            throw new BadCredentialsException(defaultMessage);
        }
        // 토큰 생성
        final String accessToken = jwtTokenProvider.createAccessToken(foundUser);    // JWT 라이브러리 이용

        return accessToken;
    }

}
