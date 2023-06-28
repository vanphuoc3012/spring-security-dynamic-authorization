package com.ph.dynamic.authorization.repository;

import com.ph.dynamic.authorization.auth.Role;
import com.ph.dynamic.authorization.auth.role.RoleEntity;
import com.ph.dynamic.authorization.auth.role.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    @Query("SELECT re.roleType FROM RoleEntity re WHERE re.userEntity.email = :email AND re.resourceId = :resourceId")
    Set<RoleType> findAllByUserEntity_EmailAndResourceId(
            @Param("email") String email, @Param("resourceId") Long resourceId);

//    @Query("SELECT re.roleType FROM RoleEntity re WHERE ")
//    Set<RoleType> findAllByUserEmailAndResourceIdAndResourceType(
//            @Param("email") String email, @Param("resourceId") Long resourceId, @Param("resourceType") String resourceType
//    );
}
