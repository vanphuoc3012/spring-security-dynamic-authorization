package com.ph.dynamic.authorization.repository;

import com.ph.dynamic.authorization.auth.role.CompanyRole;
import com.ph.dynamic.authorization.auth.role.type.CompanyRoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CompanyRoleRepository extends JpaRepository<CompanyRole, String> {
    @Query("select cr.type " +
            "from CompanyRole cr " +
            "where cr.companyEntity.id = :companyId " +
            "and cr.userEntity.id = :userId")
    Set<CompanyRoleType> findCompanyRoleTypesByUserIdAndCompanyId(@Param("userId") String userid, @Param("companyId") String companyId);
}
