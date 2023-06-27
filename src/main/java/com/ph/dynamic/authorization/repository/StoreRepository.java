package com.ph.dynamic.authorization.repository;

import com.ph.dynamic.authorization.entities.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity, String> {
}
