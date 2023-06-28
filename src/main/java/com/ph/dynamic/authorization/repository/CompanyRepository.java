package com.ph.dynamic.authorization.repository;

import com.ph.dynamic.authorization.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
