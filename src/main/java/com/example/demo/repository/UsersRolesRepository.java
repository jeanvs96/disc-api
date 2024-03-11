package com.example.demo.repository;

import com.example.demo.model.entity.UsersRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRolesRepository extends JpaRepository<UsersRolesEntity, Integer> {
    List<UsersRolesEntity> findAllByUserId(Integer userId);
}
