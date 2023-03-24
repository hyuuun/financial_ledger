package com.portfolio.financial_ledger.configure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.formLogin() // 로그인 페이지와 기타 로그인 처리 및 성공 실패 처리를 사용하겠다는 의미 입니다.
//                .loginPage("/login.do")                          // Login 화면
//                .loginProcessingUrl("/loginProcess.do")          // Login 프로세스
//                // .defaultSuccessUrl("/main.do", true)
//                .successHandler(new CustomAuthenticationSuccessHandler("/main.do")) // 인증에 성공하면 Main 페이지로 Redirect
//                // // .failureHandler(new CustomAuthenticationFailureHandler("/login-fail")) // 커스텀 핸들러를 생성하여 등록하면 인증실패
//                // 후
//                .failureUrl("/login.do?fail=true") // 인증이 실패 했을 경우 이동하는 페이지를 설정합니다.
//                .usernameParameter("userId")                    // Login ID 명칭지정 - MemberRepository 의 id와 매칭됨.
//                .passwordParameter("password")                  // Login PW 명칭지정
//        ;

        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/");


//        http.authorizeHttpRequests()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/")
//        ;

        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
