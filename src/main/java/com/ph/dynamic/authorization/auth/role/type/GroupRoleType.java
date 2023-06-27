package com.ph.dynamic.authorization.auth.role.type;

import com.ph.dynamic.authorization.auth.Role;

import java.util.HashSet;
import java.util.Set;

public enum GroupRoleType implements Role {
    EDITOR, VIEWER;
    private Set<Role> childRoles = new HashSet<>();
    static {
        EDITOR.childRoles.add(VIEWER);
    }
    @Override
    public Set<Role> getIncludedRoles() {
        return this.childRoles;
    }
}
