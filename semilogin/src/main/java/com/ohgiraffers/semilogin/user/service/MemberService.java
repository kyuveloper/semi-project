package com.ohgiraffers.semilogin.user.service;

import com.ohgiraffers.semilogin.user.dao.UserMapper;
import com.ohgiraffers.semilogin.user.model.dto.LoginUserDTO;
import com.ohgiraffers.semilogin.user.model.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service //사용자의 요청을 어떻게 처리할지 방식을 정함
public class MemberService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder encoder; //PasswordEncoder는 비밀번호 암호화

    @Transactional //롤백을 가능하게 해주는 일종의 보험역할
    public int regist(SignupDTO signupDTO){
        System.out.println("777");
        signupDTO.setPassword(encoder.encode(signupDTO.getPassword()));
        int result = userMapper.regist(signupDTO);

        return result;
    }

    public LoginUserDTO findByUserEmail(String userEmail) {

        LoginUserDTO login = userMapper.findByUserEmail(userEmail);
        System.out.println(login);
        if(!Objects.isNull(login)){
            return login;
        }else {
            System.out.println("222");
            return null;
        }
    }
}
