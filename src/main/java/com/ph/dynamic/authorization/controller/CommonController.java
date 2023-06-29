package com.ph.dynamic.authorization.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class CommonController {

    public static String getUsername() {
        var context = SecurityContextHolder.getContext();
        String username = (String) context.getAuthentication().getPrincipal();
        return username;
    }
}
