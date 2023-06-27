package com.ph.dynamic.authorization.auth;

import com.ph.dynamic.authorization.auth.role.type.SystemRoleType;

import java.util.Set;

public interface Role {
    Set<Role> getIncludedRoles();
    default boolean includes(Role role) {
        return this.equals(role) || getIncludedRoles().stream().anyMatch(childRole -> childRole.includes(role));
    }

    static Set<Role> roots() {
        return Set.of(SystemRoleType.MASTER_ADMIN);
    }
}
