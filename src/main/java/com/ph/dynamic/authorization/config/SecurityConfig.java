package com.ph.dynamic.authorization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    List<String> whiteList = List.of(
            "/login", "swagger-ui/index.html",
            "/swagger-ui/**",
            "/swagger-resources/**", "/v3/api-docs/**",
            "/h2-console/**");

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(whiteList.toArray(new String[0])).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .successHandler((req, res, a) -> res.setStatus(200))
                .failureHandler((req, res, e) -> res.setStatus(401))
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler((req, res, a) -> res.setStatus(200))
                .and()
                .exceptionHandling()
                .accessDeniedHandler((req, res, e) -> res.setStatus(403))
//                .authenticationEntryPoint((req, res, e) -> res.setStatus(401))
        ;
    }

}
