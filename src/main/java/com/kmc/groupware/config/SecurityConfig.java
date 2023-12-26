package com.kmc.groupware.config;

import com.kmc.groupware.security.MemberAuthenticaterProvider;
import com.kmc.groupware.security.MemberPrincipalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {

    @Autowired
    MemberAuthenticaterProvider memberAuthenticaterProvider;

    @Autowired
    MemberPrincipalDetailService memberPrincipalDetailService;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(memberAuthenticaterProvider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {

        security.csrf().disable()
                .headers().frameOptions().disable();

        //security.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        security.authorizeHttpRequests()
                .antMatchers("/templates/**","/api/**","/home/**","/dist/**").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/main/**")
                .hasRole("MEMBER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/home/member/login")
                .defaultSuccessUrl("/main") // 로그인 성공 시 이동할 URL
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/main/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);
        //security.formLogin().disable();

        //security.httpBasic().disable();

        security.rememberMe()
                .key("hydra12")
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                .userDetailsService(memberPrincipalDetailService)
                .rememberMeParameter("remember-me");

        return security.build();
    }
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }
}
