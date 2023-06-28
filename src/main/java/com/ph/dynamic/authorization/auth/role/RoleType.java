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
    COMPANY_FULL_ACCESS, COMPANY_EDITOR, COMPANY_VIEWER,
    STORE_FULL_ACCESS, STORE_EDITOR, STORE_VIEWER,
    USER, GUEST;

    private Set<Role> childRoles = new HashSet<>();

    static {
        MASTER_ADMIN.childRoles.add(COMPANY_FULL_ACCESS);

        COMPANY_FULL_ACCESS.childRoles.add(COMPANY_EDITOR);
        COMPANY_EDITOR.childRoles.add(COMPANY_VIEWER);
        COMPANY_EDITOR.childRoles.add(STORE_FULL_ACCESS);
        STORE_FULL_ACCESS.childRoles.add(STORE_EDITOR);
        STORE_EDITOR.childRoles.add(STORE_VIEWER);

        STORE_VIEWER.childRoles.add(USER);
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
        private final RoleType COMPANY_FULL_ACCESS = RoleType.COMPANY_FULL_ACCESS;
        private final RoleType COMPANY_EDITOR = RoleType.COMPANY_EDITOR;
        private final RoleType COMPANY_VIEWER = RoleType.COMPANY_VIEWER;
        private final RoleType STORE_FULL_ACCESS = RoleType.STORE_FULL_ACCESS;
        private final RoleType STORE_EDITOR = RoleType.STORE_EDITOR;
        private final RoleType STORE_VIEWER = RoleType.STORE_VIEWER;
        private final RoleType USER = RoleType.USER;
        private final RoleType GUEST = RoleType.GUEST;
    }
}
