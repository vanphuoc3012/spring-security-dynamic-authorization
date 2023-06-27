package com.ph.dynamic.authorization.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class GroupController {
    @GetMapping
    public String getGroups() {
        return "GET:: groups";
    }

    @PostMapping
    public String postGroups() {
        return "POST:: groups";
    }

    @PutMapping
    public String putGroups() {
        return "PUT:: groups";
    }

    @DeleteMapping
    public String delGroups() {
        return "DEL:: groups";
    }
}
