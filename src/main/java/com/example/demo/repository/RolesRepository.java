package com.example.demo.repository;

import com.example.demo.model.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {
    RolesEntity findByRoleName(String roleName);
}
