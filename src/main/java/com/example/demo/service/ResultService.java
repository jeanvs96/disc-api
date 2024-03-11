package com.example.demo.service;

import com.example.demo.model.dto.TestResultDTO;
import com.example.demo.model.entity.*;
import com.example.demo.repository.FactorCombinationRepository;
import com.example.demo.repository.OngoingTestAnswersRepository;
import com.example.demo.repository.OngoingTestsRepository;
import com.example.demo.repository.TestResultsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Getter
@Setter
@Transactional
public class ResultService {
    private final OngoingTestAnswersRepository ongoingTestAnswersRepository;
    private final OngoingTestsRepository ongoingTestsRepository;
    private final UserService userService;
    private final TestResultsRepository testResultsRepository;
    private final FactorCombinationRepository factorCombinationRepository;
    private final ObjectMapper objectMapper;
    private OngoingTestEntity ongoingTestEntity;

    public List<TestResultDTO> getUserTestsResults() {
        Optional<List<TestResultsEntity>> optionalTestResultsEntities = testResultsRepository.findAllByUserEntityOrderByTestDateDescTestResultIdDesc(userService.getLoggedUser());

        setTestResultFactorCombinations(optionalTestResultsEntities.orElseThrow());

        return optionalTestResultsEntities
                .map(testResultsEntities ->
                testResultsEntities.stream()
                .map(testResultsEntity -> objectMapper.convertValue(testResultsEntity, TestResultDTO.class))
                .collect(Collectors.toList()))
                .orElseThrow();

    }

    private void setTestResultFactorCombinations(List<TestResultsEntity> testResultsEntities) {
        testResultsEntities.forEach(testResultsEntity -> {
            testResultsEntity.setFactorCombinations(factorCombinationRepository.findFactorCombinationByTestResultId(testResultsEntity.getTestResultId()));
        });
    }

    public TestResultsEntity processFinishedTestResult() {
        TestResultsEntity testResultsEntity = new TestResultsEntity();
        testResultsEntity.setDFactor(0);
        testResultsEntity.setIFactor(0);
        testResultsEntity.setSFactor(0);
        testResultsEntity.setCFactor(0);

        List<OngoingTestAnswersEntity> testAnswers = getFinishedTest();

        sumValuesIntoFactors(testResultsEntity, testAnswers);
        decreaseValuesFromFactor(testResultsEntity, testAnswers);

        testResultsEntity.setTestId(1);
        testResultsEntity.setUserEntity(userService.getLoggedUser());
        testResultsEntity.setTestDate(new Date());

        setFactorCombinations(testResultsEntity);

        TestResultsEntity savedResult = testResultsRepository.save(testResultsEntity);

        deleteAnswersFromProcessedTest();

        return savedResult;
    }

    private void setFactorCombinations(TestResultsEntity testResultsEntity) {
        FactorEntity factorEntityD = new FactorEntity();
        factorEntityD.setFactor("D");
        factorEntityD.setValue(testResultsEntity.getDFactor());

        FactorEntity factorEntityI = new FactorEntity();
        factorEntityD.setFactor("I");
        factorEntityD.setValue(testResultsEntity.getIFactor());

        FactorEntity factorEntityS = new FactorEntity();
        factorEntityD.setFactor("S");
        factorEntityD.setValue(testResultsEntity.getSFactor());

        FactorEntity factorEntityC = new FactorEntity();
        factorEntityD.setFactor("C");
        factorEntityD.setValue(testResultsEntity.getCFactor());

        List<FactorEntity> factorEntities = List.of(factorEntityD, factorEntityI, factorEntityS, factorEntityC);

        factorEntities = factorEntities.stream()
                .sorted(Comparator.comparing(FactorEntity::getValue))
                .map(this::classifyFactorBasedOnValue)
                .collect(Collectors.toList());

        List<String> factorCombinationToRetrieve = new ArrayList<>();

        for (int i = 0; i < (factorEntities.size() - 1); i++) {
            for (int j = i + 1; j < factorEntities.size(); j++) {
                if (factorEntities.get(i).getValue().equals(factorEntities.get(j).getValue())) {
                    factorCombinationToRetrieve.add(factorEntities.get(i).getFactor() + "=" + factorEntities.get(j).getFactor());
                } else {
                    factorCombinationToRetrieve.add(factorEntities.get(i).getFactor() + factorEntities.get(j).getFactor());
                }
            }
        }

        testResultsEntity.setFactorCombinations(
                factorCombinationToRetrieve
                        .stream()
                        .map(factorCombination ->
                                factorCombinationRepository.findFactorCombinationEntityByFactorCombination(factorCombination).orElseThrow())
                        .collect(Collectors.toList())
        );
    }

    private FactorEntity classifyFactorBasedOnValue(FactorEntity factorEntity) {
        if (factorEntity.getValue() < 50) {
            factorEntity.setFactor(factorEntity.getFactor().toLowerCase());
        }
        return factorEntity;
    }

    private void sumValuesIntoFactors(TestResultsEntity testResultsEntity, List<OngoingTestAnswersEntity> testAnswers) {
        testAnswers.forEach(answer -> {
            testResultsEntity.setDFactor(testResultsEntity.getDFactor() + getValueFromPosition(answer.getDFactor()));
            testResultsEntity.setIFactor(testResultsEntity.getIFactor() + getValueFromPosition(answer.getIFactor()));
            testResultsEntity.setSFactor(testResultsEntity.getSFactor() + getValueFromPosition(answer.getSFactor()));
            testResultsEntity.setCFactor(testResultsEntity.getCFactor() + getValueFromPosition(answer.getCFactor()));
        });
    }

    private void decreaseValuesFromFactor(TestResultsEntity testResultsEntity, List<OngoingTestAnswersEntity> testAnswers) {
        testAnswers.forEach(answer -> {
            if (answer.getDFactor() == 4) {
                testResultsEntity.setSFactor(testResultsEntity.getSFactor() - 1);
            }

            if (answer.getIFactor() == 4) {
                testResultsEntity.setCFactor(testResultsEntity.getCFactor() - 1);
            }

            if (answer.getSFactor() == 4) {
                testResultsEntity.setDFactor(testResultsEntity.getDFactor() - 1);
            }

            if (answer.getCFactor() == 4) {
                testResultsEntity.setIFactor(testResultsEntity.getIFactor() - 1);
            }
        });
    }

//    private void decreaseValuesFromFactor(TestResultsEntity testResultsEntity, List<OngoingTestAnswersEntity> testAnswers) {
//        testAnswers.forEach(answer -> {
//            if (answer.getDFactor() > answer.getSFactor()) {
//                testResultsEntity.setSFactor(testResultsEntity.getSFactor() - 1);
//            } else {
//                testResultsEntity.setDFactor(testResultsEntity.getDFactor() - 1);
//            }
//
//            if (answer.getIFactor() > answer.getCFactor()) {
//                testResultsEntity.setCFactor(testResultsEntity.getCFactor() - 1);
//            } else {
//                testResultsEntity.setIFactor(testResultsEntity.getIFactor() - 1);
//            }
//        });
//    }

    private List<OngoingTestAnswersEntity> getFinishedTest() throws NoSuchElementException {
        OngoingTestEntity ongoingTestEntity = ongoingTestsRepository.findByUserEntity(userService.getLoggedUser()).orElseThrow();
        this.ongoingTestEntity = ongoingTestEntity;
        return ongoingTestAnswersRepository.findAllByOngoingTestEntity(ongoingTestEntity).orElseThrow();
    }

    private Integer getValueFromPosition(Integer position) {
        return switch (position) {
            case 1 -> 4;
            case 2 -> 3;
            case 3 -> 2;
            case 4 -> 1;
            default -> null;
        };
    }

    public void deleteAnswersFromProcessedTest() {
        ongoingTestAnswersRepository.deleteAllByOngoingTestEntity(ongoingTestEntity);
    }
}
