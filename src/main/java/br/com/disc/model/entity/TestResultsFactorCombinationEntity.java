package br.com.disc.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "test_results_factor_combination")
@Getter
@Setter
public class TestResultsFactorCombinationEntity {
    @Id
    @GeneratedValue(generator = "TEST_RESULTS_FACTOR_COMBINATION_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TEST_RESULTS_FACTOR_COMBINATION_SEQ", sequenceName = "seq_test_results_factor_combination", allocationSize = 1)
    @Column(name = "test_results_factor_combination_id", nullable = false)
    private Long testResultFactorCombinationId;

    @Column(name = "test_result_id", nullable = false)
    private Long testResultId;

    @Column(name = "factor_combination_id", nullable = false)
    private Long factorCombinationId;
}
