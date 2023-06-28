package com.ph.dynamic.authorization.auth.role;

import com.ph.dynamic.authorization.auth.Role;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public enum RoleType implements Role {
    MASTER_ADMIN, DELETE, CREATE_UPDATE, READ, USER, GUEST;

    private Set<Role> childRoles = new HashSet<>();

    static {
        MASTER_ADMIN.childRoles.add(DELETE);
        DELETE.childRoles.add(CREATE_UPDATE);
        CREATE_UPDATE.childRoles.add(READ);
        READ.childRoles.add(USER);
        USER.childRoles.add(GUEST);
    }
    @Override
    public Set<Role> getIncludedRoles() {
        log.debug("getIncludedRoles() called");
        log.debug("childRoles: {}", childRoles);
        return childRoles;
    }
}
