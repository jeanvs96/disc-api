package com.example.demo.repository;

import com.example.demo.model.entity.OngoingTestAnswersEntity;
import com.example.demo.model.entity.OngoingTestEntity;
import com.example.demo.model.entity.QuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OngoingTestAnswersRepository extends JpaRepository<OngoingTestAnswersEntity, Integer> {
    Optional<OngoingTestAnswersEntity> findByQuestionEntityAndOngoingTestEntity(QuestionsEntity questionsEntity, OngoingTestEntity ongoingTestEntity);
    Optional<List<OngoingTestAnswersEntity>> findAllByOngoingTestEntity(OngoingTestEntity ongoingTestEntity);

    void deleteAllByOngoingTestEntity(OngoingTestEntity ongoingTestEntity);

    @Modifying
    @Query(value = "delete from ongoing_test_answers ota where ota.ongoingTestEntity.ongoingTestId = :ongoingTestId")
    void deleteAllByOngoingTestId(@Param("ongoingTestId") Long ongoingTestId);
}
