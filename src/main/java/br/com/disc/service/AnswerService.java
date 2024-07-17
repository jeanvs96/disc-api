package br.com.disc.service;

import br.com.disc.model.dto.OngoingTestAnswerDTO;
import br.com.disc.model.entity.*;
import br.com.disc.repository.AnswersRepository;
import br.com.disc.repository.OngoingTestAnswersRepository;
import br.com.disc.repository.OngoingTestsRepository;
import br.com.disc.repository.QuestionsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class AnswerService {
    private final UserService userService;
    private final OngoingTestsRepository ongoingTestsRepository;
    private final QuestionsRepository questionsRepository;
    private final OngoingTestAnswersRepository ongoingTestAnswersRepository;
    private final AnswersRepository answersRepository;
    private final ObjectMapper objectMapper;

    public void saveAnswer(OngoingTestAnswerDTO ongoingTestAnswerDTO) throws NoSuchElementException {
        UserEntity loggedUser = userService.getLoggedUser();
        Optional<OngoingTestEntity> ongoingTestEntity = ongoingTestsRepository.findByUserEntity(loggedUser);

        OngoingTestAnswersEntity ongoingTestAnswersEntity = new OngoingTestAnswersEntity();

        if (ongoingTestEntity.isPresent()) {
            ongoingTestEntity.get().setCurrentQuestion(ongoingTestEntity.get().getCurrentQuestion() + 1);
            ongoingTestAnswersEntity.setOngoingTestEntity(ongoingTestEntity.get());

        } else {
            OngoingTestEntity newOngoingTestEntity = new OngoingTestEntity();
            newOngoingTestEntity.setUserEntity(loggedUser);
            newOngoingTestEntity.setCurrentQuestion(2);
            newOngoingTestEntity.setTestId(1);

            newOngoingTestEntity = ongoingTestsRepository.save(newOngoingTestEntity);

            ongoingTestAnswersEntity.setOngoingTestEntity(newOngoingTestEntity);
        }

        QuestionsEntity questionsEntity = questionsRepository.findById(ongoingTestAnswerDTO.getQuestionId()).orElseThrow();
        Optional<List<AnswersEntity>> optionalAnswersEntities = answersRepository.findAllByQuestionEntity(questionsEntity);

        if (optionalAnswersEntities.isPresent()) {

            setAnswersFactors(ongoingTestAnswersEntity, optionalAnswersEntities.get(), ongoingTestAnswerDTO);

            ongoingTestAnswersEntity.setQuestionEntity(questionsEntity);
            ongoingTestAnswersRepository.save(ongoingTestAnswersEntity);
        }
    }

    public void updateAnswer(OngoingTestAnswerDTO ongoingTestAnswerDTO) throws NoSuchElementException {
        UserEntity loggedUser = userService.getLoggedUser();
        OngoingTestAnswersEntity ongoingTestAnswersEntity = new OngoingTestAnswersEntity();

        Optional<OngoingTestAnswersEntity> recoveredOngoingTestAnswersEntity = ongoingTestAnswersRepository.findByQuestionEntityAndOngoingTestEntity(
                questionsRepository.findById(ongoingTestAnswerDTO.getQuestionId()).orElseThrow(),
                ongoingTestsRepository.findByUserEntity(loggedUser).orElseThrow()
        );

        if (recoveredOngoingTestAnswersEntity.isPresent()) {
            QuestionsEntity questionsEntity = questionsRepository.findById(ongoingTestAnswerDTO.getQuestionId()).orElseThrow();
            Optional<List<AnswersEntity>> optionalAnswersEntities = answersRepository.findAllByQuestionEntity(questionsEntity);
            Optional<OngoingTestEntity> ongoingTestEntity = ongoingTestsRepository.findByUserEntity(loggedUser);

            if (optionalAnswersEntities.isPresent()) {

                setAnswersFactors(ongoingTestAnswersEntity, optionalAnswersEntities.get(), ongoingTestAnswerDTO);

                ongoingTestAnswersEntity.setOngoingTestEntity(ongoingTestEntity.orElseThrow());
                ongoingTestAnswersEntity.setQuestionEntity(questionsEntity);
                ongoingTestAnswersEntity.setOngoingTestAnswersId(recoveredOngoingTestAnswersEntity.get().getOngoingTestAnswersId());
                ongoingTestAnswersRepository.save(ongoingTestAnswersEntity);
            }
        } else {
            saveAnswer(ongoingTestAnswerDTO);
        }
    }

    private void setAnswersFactors(OngoingTestAnswersEntity ongoingTestAnswersEntity, List<AnswersEntity> answersEntities, OngoingTestAnswerDTO ongoingTestAnswerDTO) {
        ongoingTestAnswersEntity.setDFactor(findAnswerPositionByFactor(answersEntities, ongoingTestAnswerDTO, "D"));
        ongoingTestAnswersEntity.setIFactor(findAnswerPositionByFactor(answersEntities, ongoingTestAnswerDTO, "I"));
        ongoingTestAnswersEntity.setSFactor(findAnswerPositionByFactor(answersEntities, ongoingTestAnswerDTO, "S"));
        ongoingTestAnswersEntity.setCFactor(findAnswerPositionByFactor(answersEntities, ongoingTestAnswerDTO, "C"));
    }

    private Integer findAnswerPositionByFactor(List<AnswersEntity> answersEntities, OngoingTestAnswerDTO ongoingTestAnswerDTO, String factor)
            throws NoSuchElementException{
        AnswersEntity currentAnswer = answersEntities.stream().filter(answersEntity -> answersEntity.getFactor().equals(factor)).findFirst().orElseThrow();
        return ongoingTestAnswerDTO.getAnswersPositions()
                .stream()
                .filter(answerPosition -> answerPosition.getAnswerId().equals(currentAnswer.getAnswerId().intValue()))
                .findFirst()
                .orElseThrow()
                .getPosition();
    }
}
