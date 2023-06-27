package com.ph.dynamic.authorization.auth.role.type;

import com.ph.dynamic.authorization.auth.Role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum CompanyRoleType implements Role {
    COMPANY_ADMIN,;

    private final Set<Role> childRoles = new HashSet<>();

    static {
        COMPANY_ADMIN.childRoles.addAll(Arrays.asList(StoreRoleType.values()));
    }

    @Override
    public Set<Role> getIncludedRoles() {
        return childRoles;
    }
}
