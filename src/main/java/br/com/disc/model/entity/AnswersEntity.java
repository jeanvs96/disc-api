package br.com.disc.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "answers")
@Getter
@Setter
public class AnswersEntity {
    @Id
    @GeneratedValue(generator = "ANSWER_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ANSWER_SEQ", sequenceName = "seq_answers", allocationSize = 1)
    @Column(name = "answer_id", nullable = false)
    private Long answerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionsEntity questionEntity;

    @Column(name = "answer")
    private String answer;

    @Column(name = "factor")
    private String factor;

    @Transient
    private Integer position;
}
