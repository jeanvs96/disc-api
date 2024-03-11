package com.example.demo.repository;

import com.example.demo.model.entity.AnswersEntity;
import com.example.demo.model.entity.QuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswersRepository extends JpaRepository<AnswersEntity, Integer> {
    Optional<List<AnswersEntity>> findAllByQuestionEntity(QuestionsEntity questionsEntity);
}
