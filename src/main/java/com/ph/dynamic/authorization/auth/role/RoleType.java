package com.ph.dynamic.authorization.auth.role;

import com.ph.dynamic.authorization.auth.Role;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public enum RoleType implements Role {
    MASTER_ADMIN,
    COMPANY_DELETE, COMPANY_CREATE_UPDATE, COMPANY_READ,
    STORE_DELETE, STORE_CREATE_UPDATE, STORE_READ,
    USER, GUEST;

    private Set<Role> childRoles = new HashSet<>();

    static {
        MASTER_ADMIN.childRoles.add(COMPANY_DELETE);

        COMPANY_DELETE.childRoles.add(COMPANY_CREATE_UPDATE);
        COMPANY_CREATE_UPDATE.childRoles.add(COMPANY_READ);
        COMPANY_CREATE_UPDATE.childRoles.add(STORE_DELETE);
        STORE_DELETE.childRoles.add(STORE_CREATE_UPDATE);
        STORE_CREATE_UPDATE.childRoles.add(STORE_READ);

        STORE_READ.childRoles.add(USER);
        USER.childRoles.add(GUEST);
    }

    @Override
    public Set<Role> getIncludedRoles() {
        log.debug("getIncludedRoles() called");
        log.debug("childRoles: {}", childRoles);
        return childRoles;
    }

    @Component("RoleType")
    @Getter
    static class SpringComponent {
        private final RoleType MASTER_ADMIN = RoleType.MASTER_ADMIN;
        private final RoleType COMPANY_DELETE = RoleType.COMPANY_DELETE;
        private final RoleType COMPANY_CREATE_UPDATE = RoleType.COMPANY_CREATE_UPDATE;
        private final RoleType COMPANY_READ = RoleType.COMPANY_READ;
        private final RoleType STORE_DELETE = RoleType.STORE_DELETE;
        private final RoleType STORE_CREATE_UPDATE = RoleType.STORE_CREATE_UPDATE;
        private final RoleType STORE_READ = RoleType.STORE_READ;
        private final RoleType USER = RoleType.GUEST;
    }
}
