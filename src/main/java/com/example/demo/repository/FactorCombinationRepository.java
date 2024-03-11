package com.example.demo.repository;

import com.example.demo.model.entity.FactorCombinationEntity;
import com.example.demo.model.entity.TestResultsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FactorCombinationRepository extends JpaRepository<FactorCombinationEntity, Integer> {

    @Query(value = "" +
            "select fcd from factor_combination_description fcd " +
            "join test_results_factor_combination tf on tf.factorCombinationId = fcd.factorCombinationId " +
            "join test_results tr on tf.testResultId = tr.testResultId " +
            "where tr.testResultId = :resultId " +
            "order by tf.testResultFactorCombinationId asc")
    List<FactorCombinationEntity> findFactorCombinationByTestResultId(@Param("resultId") Long resultId);

    Optional<FactorCombinationEntity> findFactorCombinationEntityByFactorCombination(String factorCombination);
}
