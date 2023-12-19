package com.ohgiraffers.semilogin.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping
    public String root(){
        return "index";
    }

    @GetMapping("/admin/page")
    public ModelAndView admnin(ModelAndView mv){
        mv.setViewName("admin/admin");
        return mv;
    }

    @GetMapping("/user/page")
    public ModelAndView user(ModelAndView mv){
        mv.setViewName("/user/user");
        return mv;
    }
}
