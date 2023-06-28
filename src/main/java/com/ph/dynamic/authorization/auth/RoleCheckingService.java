package com.ph.dynamic.authorization.auth;

import com.ph.dynamic.authorization.auth.role.ResourceType;
import com.ph.dynamic.authorization.auth.role.RoleEntity;
import com.ph.dynamic.authorization.auth.role.RoleType;
import com.ph.dynamic.authorization.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("RoleCheckingService")
@RequiredArgsConstructor
@Slf4j
public class RoleCheckingService {
    private final RoleRepository roleRepository;

    public boolean hasAnyRoleByResourcesId(Long resouresId, RoleType... roleList) {
        log.debug("## hasAnyRoleByResourcesId:, resouresId: {}, roleList: {}", resouresId, roleList);

        Set<RoleType> roleTypes = roleRepository.findAllByUserEntity_EmailAndResourceId(getUserName(), resouresId);
        log.debug("Query result: {}", roleTypes);

        for (RoleType expectedRole : roleList) {
            if (roleTypes.stream().anyMatch(role -> role.includes(expectedRole))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAnyRoleByCompanyId(Long companyId, Role... roleList) {
        return false;
    }

    public boolean hasAnyRole(Role... roleList) {

        return true;
    }

    private String getUserName() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
