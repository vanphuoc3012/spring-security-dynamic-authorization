package com.ph.dynamic.authorization.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
public class StoreController {
    @GetMapping
    public String getStores() {
        return "GET:: stores";
    }

    @PostMapping
    public String postStores() {
        return "POST:: stores";
    }

    @PutMapping
    public String putStores() {
        return "PUT:: stores";
    }

    @DeleteMapping
    public String delStores() {
        return "DEL:: stores";
    }
}
