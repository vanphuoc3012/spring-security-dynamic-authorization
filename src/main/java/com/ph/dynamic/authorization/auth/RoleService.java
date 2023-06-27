package com.ph.dynamic.authorization.auth;

import org.springframework.stereotype.Service;

public interface RoleService {
    boolean hasRole(String id, Role... roles);
}
