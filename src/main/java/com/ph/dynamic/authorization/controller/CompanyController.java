package com.ph.dynamic.authorization.controller;

import com.ph.dynamic.authorization.entities.CompanyEntity;
import com.ph.dynamic.authorization.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyRepository companyRepository;

    /**
     * Get all companies in system
     * => Madive admin Role
     * @return
     */
    @GetMapping
    @PreAuthorize("@RoleCheckingService.hasMasterAdmin()")
    public String getCompanies() {
        return "GET:: companies";
    }


    /**
     * Get company information by company id
     * => Company viewer and
     * @param companyId
     * @return
     */
    @GetMapping("/{companyId}")
    @PreAuthorize("@RoleCheckingService.hasAnyRoleByCompanyId(#companyId, @RoleType.COMPANY_EDITOR)")
    public ResponseEntity<CompanyEntity> getCompany(@PathVariable Long companyId) {
        return ResponseEntity.ok(Objects.requireNonNull(companyRepository.findById(companyId).orElse(null)));
    }


    @PostMapping
    @PreAuthorize("@RoleCheckingService.hasMasterAdmin()")
    public ResponseEntity<Long> postCompanies(@RequestBody CompanyEntity companyEntity) {
        companyEntity = companyRepository.save(companyEntity);
        return ResponseEntity.ok(companyEntity.getId());
    }

    @PutMapping("/companyId")
    @PreAuthorize("@RoleCheckingService.hasAnyRoleByCompanyId(#companyId, @RoleType.COMPANY_EDITOR)")
    public String putCompanies() {
        return "PUT:: companies";
    }

    @DeleteMapping("/{companyId}")
    @PreAuthorize("@RoleCheckingService.hasAnyRoleByCompanyId(#companyId, @RoleType.COMPANY_FULL_ACCESS)")
    public String delCompanies() {
        return "DEL:: companies";
    }

    @PostMapping("/{companyId}/stores")
    @PreAuthorize("@RoleCheckingService.hasAnyRoleByCompanyId(#companyDto.id, @RoleType.COMPANY_VIEWER, @RoleType.COMPANY_EDITOR)")
    public String getCompanyStores(@PathVariable Long companyId, @RequestBody CompanyDto companyDto) {
        return "GET:: companies stores of company id: " + companyId;
    }
}
