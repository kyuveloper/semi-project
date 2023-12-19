package com.ohgiraffers.semilogin.auth.service;

import com.ohgiraffers.semilogin.auth.model.AuthDetails;
import com.ohgiraffers.semilogin.user.model.dto.LoginUserDTO;
import com.ohgiraffers.semilogin.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private MemberService memberService;

    /**
     * AuthenticationProvider에서 호출하는 메서드로
     * login 요청시 전달된 사용자의 id를 매개변수로 DB에서 사용자의 정보를 찾는다.
     * 전달된 사용자의 개체 타입은 UserDetails를 구현한 구현체가 되어야 한다.
     * */
    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        LoginUserDTO login = memberService.findByUserEmail(userEmail);
        if(Objects.isNull(login)){
            System.out.println(userEmail);
            System.out.println("1234");
            throw new UsernameNotFoundException("회원정보가 존재하지 않습니다.");
        }
        return new AuthDetails(login);
    }
}
