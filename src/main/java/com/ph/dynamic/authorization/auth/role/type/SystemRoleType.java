package com.ph.dynamic.authorization.auth.role.type;

import com.ph.dynamic.authorization.auth.Role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum SystemRoleType implements Role {
    MASTER_ADMIN;
    private Set<Role> childRoles = new HashSet<>();
    static {
        MASTER_ADMIN.childRoles.addAll(Arrays.asList(CompanyRoleType.values()));
    }
    @Override
    public Set<Role> getIncludedRoles() {
        return childRoles;
    }
}