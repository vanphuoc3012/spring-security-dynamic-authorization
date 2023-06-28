package com.ph.dynamic.authorization.auth;

import com.ph.dynamic.authorization.auth.component.AdminAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompanyRoleServiceImpl implements RoleService {
    @Override
    public boolean hasRole(String id, Role... roles) {
        final String userEmail = (String) ((AdminAuthentication) SecurityContextHolder.getContext().getAuthentication()).getPrincipal();

        for (Role role : roles) {
        }

        return false;
    }
}
