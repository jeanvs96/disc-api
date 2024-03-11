package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ongoing_test_answers")
@Getter
@Setter
public class OngoingTestAnswersEntity {
    @Id
    @GeneratedValue(generator = "ONGOING_TEST_ANSWERS_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ONGOING_TEST_ANSWERS_SEQ", sequenceName = "seq_ongoing_test_answers", allocationSize = 1)
    @Column(name = "ongoing_test_answers_id", nullable = false)
    private Long ongoingTestAnswersId;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ongoing_test_id", referencedColumnName = "ongoing_test_id")
    @JsonBackReference
    private OngoingTestEntity ongoingTestEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    @JsonBackReference
    private QuestionsEntity questionEntity;

    @Column(name = "d_factor")
    private Integer dFactor;

    @Column(name = "i_factor")
    private Integer iFactor;

    @Column(name = "s_factor")
    private Integer sFactor;

    @Column(name = "c_factor")
    private Integer cFactor;

}
