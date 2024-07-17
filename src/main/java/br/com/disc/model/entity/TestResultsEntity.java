package br.com.disc.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity(name = "test_results")
@Getter
@Setter
public class TestResultsEntity {
    @Id
    @GeneratedValue(generator = "RESULT_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "RESULT_SEQ", sequenceName = "seq_test_results", allocationSize = 1)
    @Column(name = "test_result_id", nullable = false)
    private Long testResultId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    @JsonBackReference
    private UserEntity userEntity;

    @Column(name = "test_id")
    private Integer testId;

    @Column(name = "d_factor")
    private Integer dFactor;

    @Column(name = "i_factor")
    private Integer iFactor;

    @Column(name = "s_factor")
    private Integer sFactor;

    @Column(name = "c_factor")
    private Integer cFactor;

    @Column(name = "test_date")
    private Date testDate;

    @ManyToMany
    @JoinTable(
            name = "test_results_factor_combination",
            joinColumns = @JoinColumn(name = "test_result_id"),
            inverseJoinColumns = @JoinColumn(name = "factor_combination_id")
    )
    private List<FactorCombinationEntity> factorCombinations;

    @Transient
    private MainFactorEntity mainFactor;
}
