package com.ph.dynamic.authorization.auth;

import com.ph.dynamic.authorization.auth.component.AdminAuthentication;
import com.ph.dynamic.authorization.auth.role.type.CompanyRoleType;
import com.ph.dynamic.authorization.repository.CompanyRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompanyRoleServiceImpl implements RoleService {
    private final CompanyRoleRepository companyRoleRepository;
    @Override
    public boolean hasRole(String id, Role... roles) {
        final String userEmail = (String) ((AdminAuthentication) SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
        final Set<CompanyRoleType> companyRoleTypes =
                companyRoleRepository.findCompanyRoleTypesByUserIdAndCompanyId(userEmail, id);

        for (Role role : roles) {
            if (companyRoleTypes.stream().anyMatch(companyRoleType -> companyRoleType.includes(role))) {
                return true;
            }
        }

        return false;
    }
}
