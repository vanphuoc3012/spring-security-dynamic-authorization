package com.ph.dynamic.authorization.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menus")
public class MenuController {
    @GetMapping
    public String getMenus() {
        return "GET:: menus";
    }

    @PostMapping
    public String postMenus() {
        return "POST:: menus";
    }

    @PutMapping
    public String putMenus() {
        return "PUT:: menus";
    }

    @DeleteMapping
    public String delMenus() {
        return "DEL:: menus";
    }
}
