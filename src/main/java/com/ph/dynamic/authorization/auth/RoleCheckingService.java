package com.ph.dynamic.authorization.auth;

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

    public boolean hasAnyRoleByCompanyId(Long companyId, RoleType... roleTypeList) {
        log.debug(getUserName());
        if (hasMasterAdmin()) {
            return true;
        }
        log.debug("## hasAnyRoleByCompanyId:, companyId: {}, roleTypeList: {}", companyId, roleTypeList);
        var roleTypes = roleRepository.findAllRoleTypeByUserEmailAndCompanyId(getUserName(), companyId);
        log.debug("Query result: {}", roleTypes);
        for (RoleType expectedRole : roleTypeList) {
            if (roleTypes.stream().anyMatch(role -> role.includes(expectedRole))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAnyRoleByStoreId(Long storeId, RoleType... roleTypeList) {
        if (hasMasterAdmin()) {
            return true;
        }
        log.debug("## hasAnyRoleByStoreId:, storeId: {}, roleTypeList: {}", storeId, roleTypeList);
        var roleTypes = roleRepository.findAllRoleTypeByUserEmailAndStoreId(getUserName(), storeId);
        log.debug("Query result: {}", roleTypes);
        for (RoleType expectedRole : roleTypeList) {
            if (roleTypes.stream().anyMatch(role -> role.includes(expectedRole))) {
                return true;
            }
        }
        return false;
    }
    @Deprecated
    public boolean hasAnyRoleByResourcesId(Long resourceId, RoleType... roleList) {
        log.debug("## hasAnyRoleByResourcesId:, resourceId: {}, roleList: {}", resourceId, roleList);

        Set<RoleType> roleTypes = roleRepository.findAllByUserEntity_EmailAndResourceId(getUserName(), resourceId);
        log.debug("Query result: {}", roleTypes);

        for (RoleType expectedRole : roleList) {
            if (roleTypes.stream().anyMatch(role -> role.includes(expectedRole))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMasterAdmin() {
        log.debug(getUserName());
        Set<RoleType> roleTypes = roleRepository.findAllByUserEmail(getUserName());
        return roleTypes.stream().anyMatch(role -> role.includes(RoleType.MASTER_ADMIN));
    }

    private String getUserName() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
