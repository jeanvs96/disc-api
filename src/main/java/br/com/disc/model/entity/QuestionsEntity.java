package br.com.disc.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "questions")
@Getter
@Setter
public class QuestionsEntity {
    @Id
    @GeneratedValue(generator = "QUESTIONS_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "QUESTIONS_SEQ", sequenceName = "seq_questions", allocationSize = 1)
    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @Column(name = "question", nullable = false)
    private String question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="test_id", nullable=false)
    private TestsEntity testEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionEntity")
    @Transient
    private List<AnswersEntity> answerEntities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionEntity")
    @Transient
    private List<OngoingTestAnswersEntity> ongoingTestAnswers;
}
