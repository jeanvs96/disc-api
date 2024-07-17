package br.com.disc.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "factor_combination_description")
@Getter
@Setter
public class FactorCombinationEntity {
    @Id
    @GeneratedValue(generator = "FACTOR_COMBINATION_DESCRIPTION_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "FACTOR_COMBINATION_DESCRIPTION_SEQ", sequenceName = "seq_factor_combination_description", allocationSize = 1)
    @Column(name = "factor_combination_id", nullable = false)
    private Long factorCombinationId;

    @Column(name = "factor_combination")
    private String factorCombination;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "test_results_factor_combination",
            joinColumns = @JoinColumn(name = "factor_combination_id"),
            inverseJoinColumns = @JoinColumn(name = "test_result_id")
    )
    @Transient
    private List<TestResultsEntity> testResultsEntities;
}
