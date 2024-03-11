package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ongoing_test")
@Getter
@Setter
public class OngoingTestEntity {
    @Id
    @GeneratedValue(generator = "ONGOING_TEST_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ONGOING_TEST_SEQ", sequenceName = "seq_ongoing_test", allocationSize = 1)
    @Column(name = "ongoing_test_id", nullable = false)
    private Long ongoingTestId;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;

    @Column(name = "current_question")
    private Integer currentQuestion;

    @Column(name = "test_id")
    private Integer testId;


}
