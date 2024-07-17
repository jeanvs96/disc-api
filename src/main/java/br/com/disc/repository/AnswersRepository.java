package br.com.disc.repository;

import br.com.disc.model.entity.AnswersEntity;
import br.com.disc.model.entity.QuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswersRepository extends JpaRepository<AnswersEntity, Integer> {
    Optional<List<AnswersEntity>> findAllByQuestionEntity(QuestionsEntity questionsEntity);
}
