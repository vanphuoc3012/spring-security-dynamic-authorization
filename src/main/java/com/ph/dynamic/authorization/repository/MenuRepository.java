package com.ph.dynamic.authorization.repository;

import com.ph.dynamic.authorization.entities.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
}
