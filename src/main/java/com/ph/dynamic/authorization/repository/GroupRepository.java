package com.ph.dynamic.authorization.repository;

import com.ph.dynamic.authorization.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, String> {
}
