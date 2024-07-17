package br.com.disc.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "tests")
@Data
public class TestsEntity {
    @Id
    @GeneratedValue(generator = "TEST_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TEST_SEQ", sequenceName = "seq_tests", allocationSize = 1)
    @Column(name = "test_id", nullable = false)
    private Long testId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "testEntity")
    @Transient
    private List<TestResultsEntity> resultEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "testEntity")
    @Transient
    private List<QuestionsEntity> questionEntities;
}
