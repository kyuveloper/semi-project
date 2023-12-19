package com.ohgiraffers.semilogin.config;

import com.ohgiraffers.semilogin.common.UserAuth;
import com.ohgiraffers.semilogin.config.handler.AuthFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthFailHandler authFailHandler;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean // 정적리소스의 대한 요청을 제외하겠다는 설정 static 파일 하위
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->{ //서버의 리소스에 접근 가능한 권한을 설정함
            auth.requestMatchers("/auth/login","/user/signup","/auth/fail","/").permitAll();
            auth.requestMatchers("/admin/*").hasAnyAuthority(UserAuth.ADMIN.getAuth());
            auth.requestMatchers("/user/*").hasAnyAuthority(UserAuth.USER.getAuth());
            auth.anyRequest().authenticated(); //anyRequest:모든 요청 authenticated:인증된
            //인증된 사용자는 전부 사용 가능
        }).formLogin(login ->{
            login.loginPage("/auth/login"); // 로그인 페이지에 해당되는 서블릿이 존재해야 한다.
            // /auth/login 으로 커스텀하겠다
            login.usernameParameter("user");
            login.passwordParameter("pass");
            login.defaultSuccessUrl("/"); // 서블릿이 존재해야 한다.
            login.failureHandler(authFailHandler);
        }).logout(logout ->{
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"));
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true); // 세션을 소멸하도록 허용하는 것
            logout.logoutSuccessUrl("/"); // 로그아웃 시 이동할 페이지 설정
        }).sessionManagement(session ->{
            session.maximumSessions(1); //session의 허용 개수를 제한
            session.invalidSessionUrl("/"); // 세션만료시 이동할 페이지
        }).csrf(csrf -> csrf.disable());

        return http.build();
    }
}
