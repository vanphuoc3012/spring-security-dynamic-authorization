package com.ph.dynamic.authorization.auth.role.type;

import com.ph.dynamic.authorization.auth.Role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum StoreRoleType implements Role {
    MANAGER, EDITOR, VIEWER;

    private Set<Role> childRoles = new HashSet<>();
    static {
        MANAGER.childRoles.add(EDITOR);
        EDITOR.childRoles.add(VIEWER);
        EDITOR.childRoles.addAll(Arrays.asList(GroupRoleType.values()));
        VIEWER.childRoles.add(GroupRoleType.VIEWER);
    }
    @Override
    public Set<Role> getIncludedRoles() {
        return this.childRoles;
    }
}
