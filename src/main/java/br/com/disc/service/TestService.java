package br.com.disc.service;

import br.com.disc.model.dto.AnswerDTO;
import br.com.disc.model.dto.QuestionDTO;
import br.com.disc.model.dto.TestDTO;
import br.com.disc.model.entity.*;
import br.com.disc.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TestService {
    private final TestsRepository testsRepository;
    private final QuestionsRepository questionsRepository;
    private final AnswersRepository answersRepository;
    private final UserService userService;
    private final OngoingTestsRepository ongoingTestsRepository;
    private final OngoingTestAnswersRepository ongoingTestAnswersRepository;
    private final ObjectMapper objectMapper;

    public TestDTO getTest(String testId, Boolean ongoingTest) throws NoSuchElementException {
        TestsEntity test = testsRepository.findById(Integer.parseInt(testId)).orElseThrow();
        Optional<List<QuestionsEntity>> questionsList = questionsRepository.findAllByTestEntityOrderByQuestionIdAsc(test);

        TestDTO testDTO = new TestDTO();
        testDTO.setCurrentQuestion(0);

        List<QuestionDTO> questionDTOList = questionsList.orElseThrow()
                .stream()
                .map(questionsEntity -> {
                    Optional<List<AnswersEntity>> optionalAnswersEntities = answersRepository.findAllByQuestionEntity(questionsEntity);
                    List<AnswersEntity> answersEntities = optionalAnswersEntities.orElseThrow();

                    if (ongoingTest) {
                        Optional<OngoingTestEntity> optionalOngoingTestEntity = ongoingTestsRepository.findByUserEntity(userService.getLoggedUser());

                        testDTO.setIsAnOngoingTest(optionalOngoingTestEntity.isPresent());
                        optionalOngoingTestEntity.ifPresent(ongoingTestEntity -> setOngoingTestAnswersPositions(ongoingTestEntity, answersEntities, testDTO));
                    }

                    List<AnswerDTO> answerDTOList = new java.util.ArrayList<>(answersEntities.stream().map(this::transformAnswerEntityToDto).toList());
                    setAnswersPositions(answerDTOList);
                    QuestionDTO questionDTO = transformQuestionEntityToDto(questionsEntity);
                    questionDTO.setAnswers(answerDTOList);
                    return questionDTO;
                })
                .collect(Collectors.toList());
        testDTO.setTestId(test.getTestId());
        testDTO.setQuestions(questionDTOList);

        return testDTO;
    }

    public Boolean checkIfUserHasAnOngoingTest() {
        UserEntity loggedUser = userService.getLoggedUser();
        Optional<OngoingTestEntity> optionalOngoingTestEntity = ongoingTestsRepository.findByUserEntity(loggedUser);

        return optionalOngoingTestEntity.isPresent();
    }

    @Transactional
    public void deleteOngoingTest() {
        Optional<OngoingTestEntity> optionalOngoingTestEntity = ongoingTestsRepository.findByUserEntity(userService.getLoggedUser());

        optionalOngoingTestEntity.ifPresent(ongoingTestAnswersRepository::deleteAllByOngoingTestEntity);
        optionalOngoingTestEntity.ifPresent(ongoingTestsRepository::delete);
    }

    private void setAnswersPositions(List<AnswerDTO> answerDTOList) {
        Collections.shuffle(answerDTOList);
        for (int i = 0; i < answerDTOList.size(); i++) {
            if (answerDTOList.get(i).getPosition() == null) {
            answerDTOList.get(i).setPosition(i + 1);
            }
        }

        answerDTOList.sort(Comparator.comparing(AnswerDTO::getPosition));
    }
    
    private void setOngoingTestAnswersPositions(OngoingTestEntity ongoingTestEntity, List<AnswersEntity> answersEntities, TestDTO testDTO) {
        Optional<List<OngoingTestAnswersEntity>> ongoingTestAnswersEntities = ongoingTestAnswersRepository.findAllByOngoingTestEntity(ongoingTestEntity);
        testDTO.setCurrentQuestion(ongoingTestAnswersEntities.orElseThrow().size());
        answersEntities.forEach(answerEntity -> {
            Optional<OngoingTestAnswersEntity> matchedAnswer = ongoingTestAnswersEntities.get()
                    .stream()
                    .filter(ongoingTestAnswersEntity -> ongoingTestAnswersEntity.getQuestionEntity().getQuestionId().equals(answerEntity.getQuestionEntity().getQuestionId()))
                    .findFirst();
            if (matchedAnswer.isPresent()) {
                switch (answerEntity.getFactor()) {
                    case "D" -> answerEntity.setPosition(matchedAnswer.get().getDFactor());
                    case "I" -> answerEntity.setPosition(matchedAnswer.get().getIFactor());
                    case "S" -> answerEntity.setPosition(matchedAnswer.get().getSFactor());
                    case "C" -> answerEntity.setPosition(matchedAnswer.get().getCFactor());
                }
            }
        });
    }

    private QuestionDTO transformQuestionEntityToDto(QuestionsEntity questionsEntity) {
        return objectMapper.convertValue(questionsEntity, QuestionDTO.class);
    }

    private AnswerDTO transformAnswerEntityToDto(AnswersEntity answersEntity) {
        return objectMapper.convertValue(answersEntity, AnswerDTO.class);
    }
}
