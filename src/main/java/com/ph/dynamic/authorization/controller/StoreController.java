package com.ph.dynamic.authorization.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company/{companyId}/stores")
public class StoreController {
    @GetMapping
    @PreAuthorize("@RoleCheckingService.hasAnyRoleByResourcesId(#companyId, @RoleType.STORE_READ)")
    public String getStores(@PathVariable("companyId") Long companyId) {
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
