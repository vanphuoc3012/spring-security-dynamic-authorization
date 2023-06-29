package com.ph.dynamic.authorization.controller;

import com.ph.dynamic.authorization.entities.StoreEntity;
import com.ph.dynamic.authorization.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreRepository storeRepository;
    @GetMapping
    @PreAuthorize("@RoleCheckingService.hasMasterAdmin()")
    public ResponseEntity<List<StoreEntity>> getStores() {
        return ResponseEntity.ok(storeRepository.findAll());
    }

    @GetMapping("/{storeId}")
    @PreAuthorize("@RoleCheckingService.hasAnyRoleByStoreId(#storeId, @RoleType.STORE_VIEWER)")
    public String getStoresById(@PathVariable("storeId") Long storeId) {

        return "GET:: stores by id " + storeId + " " + CommonController.getUsername();
    }

    @PostMapping
    public String postStores(@PathVariable("companyId") Long companyId) {
        return "POST:: stores";
    }

    @PutMapping
    public String putStores(@PathVariable("companyId") Long companyId) {
        return "PUT:: stores";
    }

    @DeleteMapping
    public String delStores(@PathVariable("companyId") Long companyId) {
        return "DEL:: stores";
    }
}
