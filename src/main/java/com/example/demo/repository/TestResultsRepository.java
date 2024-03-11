package com.example.demo.repository;

import com.example.demo.model.entity.TestResultsEntity;
import com.example.demo.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestResultsRepository extends JpaRepository<TestResultsEntity, Integer> {
    Optional<List<TestResultsEntity>> findAllByUserEntityOrderByTestDateDescTestResultIdDesc(UserEntity userEntity);

}
