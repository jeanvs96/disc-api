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

    @Column(name = "combination_details")
    private String combinationDetails;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "characteristics")
    private String characteristics;;

    @Column(name = "strengths")
    private String strengths;

    @Column(name = "challenges")
    private String challenges;

    @Column(name = "stands_out")
    private String standsOut;

    @Column(name = "report_intro")
    private String reportIntro;;

    @Column(name = "job_search")
    private String jobSearch;

    @Column(name = "work_environment")
    private String workEnvironment;

    @Column(name = "long_term_career")
    private String longTermCareer;

    @ManyToMany
    @JoinTable(
            name = "test_results_factor_combination",
            joinColumns = @JoinColumn(name = "factor_combination_id"),
            inverseJoinColumns = @JoinColumn(name = "test_result_id")
    )
    @Transient
    private List<TestResultsEntity> testResultsEntities;
}
