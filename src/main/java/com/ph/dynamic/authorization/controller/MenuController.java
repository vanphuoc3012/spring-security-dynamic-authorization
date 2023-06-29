package com.ph.dynamic.authorization.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/menus")
public class MenuController {
    @GetMapping
//    @PreAuthorize()
    public String getMenus() {
        return "GET:: menus";
    }

    @PostMapping
    @PreAuthorize("@RoleCheckingService.hasMasterAdmin()")
    public String postMenus() {
        return "POST:: menus";
    }

    @PutMapping
    @PreAuthorize("@RoleCheckingService.hasMasterAdmin()")
    public String putMenus(Principal principal){

        return "PUT:: menus" + " " + principal;
    }

    @DeleteMapping
    @PreAuthorize("@RoleCheckingService.hasMasterAdmin()")
    public String delMenus() {
        return "DEL:: menus";
    }
}
