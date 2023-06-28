package com.ph.dynamic.authorization.controller;

import com.ph.dynamic.authorization.entities.CompanyEntity;
import com.ph.dynamic.authorization.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyRepository companyRepository;

    @GetMapping
    // System admin role
    public String getCompanies() {
        return "GET:: companies";
    }

    @GetMapping("/{id}")
    // Company admin role
    public ResponseEntity<CompanyEntity> getCompany(@PathVariable Long id) {
        return ResponseEntity.ok(companyRepository.findById(id).orElse(null));
    }


    @PostMapping
    // System admin role
    public ResponseEntity<Long> postCompanies(@RequestBody CompanyEntity companyEntity) {
        companyEntity = companyRepository.save(companyEntity);
        return ResponseEntity.ok(companyEntity.getId());
    }

    @PutMapping
    // Company admin role
    public String putCompanies() {
        return "PUT:: companies";
    }

    @DeleteMapping("/{id}")
    // Company admin roles
    public String delCompanies() {
        return "DEL:: companies";
    }
}
