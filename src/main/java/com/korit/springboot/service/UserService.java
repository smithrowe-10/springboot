package com.korit.springboot.service;

import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.exception.DuplicatedException;
import com.korit.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
//  중간에 오류가 생기면 지금까지의 과정을 커밋하지 마라   (rollbackFor = Exception.class) 어떤 오류가 터지든 롤백해라
    public int createUser(CreateUserReqDto dto) {
        UserEntity userEntity = dto.toEntity();
        System.out.println(userEntity);
        userMapper.insert(userEntity);
        System.out.println(userEntity);
        return userEntity.getUserId();
        // 이렇게 하면 insert 될때 알아서 id AutoIncrement 해준다고함 (xml 참고) id 리턴도 해줄수 있고 좋음 앞으로 insert는 이렇게만듬
        // 원래는 DB에서만 id값이 올랐는데 여기서 id 값을 가져올수 있다는게 메리트임 UserController 참고
    }

    public void duplicatedUsername(String username){
        UserEntity foundUser = userMapper.findUserByUsername(username);
//        if (foundUser != null) {
//            MethodParameter methodParameter = new MethodParameter(this.getClass().getMethod("duplicatedUsername", String.class), 2);
//            BindingResult bindingResult = new BeanPropertyBindingResult(foundUser, "");
//            FieldError fieldError = new FieldError("username", "username", "이미 사용중인 사용자이름입니다.");
//            bindingResult.addError(fieldError);
//            throw new MethodArgumentNotValidException(methodParameter, bindingResult);
//        }
        if (foundUser != null) {
            throw new DuplicatedException("username", "이미 존재하는 사용자이름입니다.");
        }
    }
}