package com.ph.dynamic.authorization.repository;

import com.ph.dynamic.authorization.auth.role.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
