package com.portfolio.financial_ledger.configure;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //csrf 설정
        http.csrf().disable();

        http.cors();

        // 로그인 관련 처리
        http.formLogin()
                .usernameParameter("setting_key")
                .passwordParameter("setting_value")
                .loginPage("/login")
                .failureUrl("/login/error")
                .defaultSuccessUrl("/dashboard");

        //로그아웃 처리
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true);

        // url 별 권한에 따른 처리
        http.authorizeHttpRequests()
                .requestMatchers("/login/**").permitAll()
                .requestMatchers("/dashboard").hasRole("ADMIN")
                .anyRequest().authenticated();

        // 로그인 세션 처리
        http.sessionManagement()
                .maximumSessions(1)
                .sessionRegistry(sessionRegistry())
                .maxSessionsPreventsLogin(false)
                .expiredUrl("/login");


        return http.build();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        String[] staticResources  =  {
                "/assets/css/**",
                "/assets/img/**",
                "/assets/js/**",
                "/assets/vendor/**",
        };
        return (web) -> web.ignoring().requestMatchers(staticResources);
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    public static ServletListenerRegistrationBean httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
