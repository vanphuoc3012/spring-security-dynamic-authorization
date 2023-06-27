package com.ph.dynamic.authorization.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @GetMapping
    public String getCompanies() {
        return "GET:: companies";
    }

    @PostMapping
    public String postCompanies() {
        return "POST:: companies";
    }

    @PutMapping
    public String putCompanies() {
        return "PUT:: companies";
    }

    @DeleteMapping
    public String delCompanies() {
        return "DEL:: companies";
    }
}
