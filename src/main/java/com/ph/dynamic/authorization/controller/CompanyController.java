package com.ph.dynamic.authorization.controller;

import com.ph.dynamic.authorization.entities.CompanyEntity;
import com.ph.dynamic.authorization.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyRepository companyRepository;
    @GetMapping
    public String getCompanies() {
        return "GET:: companies";
    }

    @PostMapping
    public ResponseEntity<String> postCompanies(@RequestBody CompanyEntity companyEntity) {
        companyEntity = companyRepository.save(companyEntity);
        return ResponseEntity.ok(companyEntity.getId());
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
