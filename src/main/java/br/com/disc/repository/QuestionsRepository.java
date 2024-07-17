package br.com.disc.repository;

import br.com.disc.model.entity.QuestionsEntity;
import br.com.disc.model.entity.TestsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionsRepository extends JpaRepository<QuestionsEntity, Integer> {
    Optional<List<QuestionsEntity>> findAllByTestEntityOrderByQuestionIdAsc(TestsEntity testsEntity);
}
