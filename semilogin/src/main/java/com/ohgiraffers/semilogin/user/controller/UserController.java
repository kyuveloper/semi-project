package com.ohgiraffers.semilogin.user.controller;

import com.ohgiraffers.semilogin.user.model.dto.SignupDTO;
import com.ohgiraffers.semilogin.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //사용자의 요청을 받아줌
@RequestMapping("/user") //user 디렉토리와 매칭함
public class UserController {

    @Autowired //bean을 찾아 의존성 주입을 해준다
    private MemberService memberService;
    @GetMapping("/signup")
    public void signup(){

    }

    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute SignupDTO signupDTO, ModelAndView mv){
        //@ModelAttribute 사용자가 요청시 전달하는 값을 오브젝트 형태로 매핑해주는 어노테이션
        // 유효성 검사 로직 추가
        System.out.println("444");
        int result = memberService.regist(signupDTO);
        System.out.println("123");
        // int로 해야 변동된걸 확인하기 String보다 훨씬 수월함

        String message;
        if(result>0){ // 회원가입이 성공하면 result의 값이 증가함
            message = "회원가입이 완료되었습니다.";
            mv.setViewName("auth/login"); // 성공했으니 로그인화면으로 넘어감
        }else {
            message="회원가입이 실패되었습니다.";
            mv.setViewName("user/signup"); // 실패해서 다시 회원가입페이지로 돌아옴
        }

        System.out.println(result);
        mv.addObject("message",message); // 상황에 따른 message 출력

        return mv;
    }
}
