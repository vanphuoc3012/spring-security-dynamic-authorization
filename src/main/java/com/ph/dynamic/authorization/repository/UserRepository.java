package com.ph.dynamic.authorization.repository;

import com.ph.dynamic.authorization.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
