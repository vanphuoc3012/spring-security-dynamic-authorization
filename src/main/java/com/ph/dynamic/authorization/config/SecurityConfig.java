package com.ph.dynamic.authorization.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    List<String> whiteList = List.of(
            "/login", "swagger-ui.html",
            "/swagger-ui/**",
            "/swagger-resources/**", "/v3/api-docs/**");



}
