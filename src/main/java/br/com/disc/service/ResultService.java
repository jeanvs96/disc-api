package br.com.disc.service;

import br.com.disc.model.dto.TestResultDTO;
import br.com.disc.model.entity.FactorEntity;
import br.com.disc.model.entity.OngoingTestAnswersEntity;
import br.com.disc.model.entity.OngoingTestEntity;
import br.com.disc.model.entity.TestResultsEntity;
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
    private final MainFactorRepository mainFactorRepository;
    private OngoingTestEntity ongoingTestEntity;

    public List<TestResultDTO> getUserTestsResults() {
        Optional<List<TestResultsEntity>> optionalTestResultsEntities = testResultsRepository.findAllByUserEntityOrderByTestDateDescTestResultIdDesc(userService.getLoggedUser());

        setTestResultFactorCombinations(optionalTestResultsEntities.orElseThrow());

        setMainFactor(optionalTestResultsEntities.orElseThrow());

        return optionalTestResultsEntities
                .map(testResultsEntities ->
                testResultsEntities.stream()
                .map(testResultsEntity -> objectMapper.convertValue(testResultsEntity, TestResultDTO.class))
                .collect(Collectors.toList()))
                .orElseThrow();

    }

    private void setTestResultFactorCombinations(List<TestResultsEntity> testResultsEntities) {
        testResultsEntities.forEach(testResultsEntity -> {
            testResultsEntity.setFactorCombinations(List.of(factorCombinationRepository.findFactorCombinationByTestResultId(testResultsEntity.getTestResultId()).get(0)));
        });
    }

    private void setMainFactor(List<TestResultsEntity> testResultsEntities) {
        testResultsEntities.forEach(testResultsEntity -> {
            testResultsEntity.setMainFactor(mainFactorRepository.findByFactor(getMainFactor(testResultsEntity)).orElseThrow());
        });
    }

    private String getMainFactor(TestResultsEntity testResultsEntity) {
        List<FactorEntity> factorEntities = getFactorEntityList(testResultsEntity);

        return factorEntities
                .stream()
                .sorted(Comparator.comparing(FactorEntity::getValue).thenComparing(FactorEntity::getFactorOrder))
                .toList()
                .get(factorEntities.size() - 1)
                .getFactor();
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
        List<FactorEntity> factorEntities = getFactorEntityList(testResultsEntity);

        factorEntities = factorEntities.stream()
                .sorted(Comparator.comparing(FactorEntity::getValue))
                .map(this::classifyFactorBasedOnValue)
                .collect(Collectors.toList());
        Collections.reverse(factorEntities);

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
                                factorCombinationRepository.findFactorCombinationEntityByFactorCombination(factorCombination).orElse(null))
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList())
        );

        testResultsEntity.setFactorCombinations(testResultsEntity.getFactorCombinations());
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

    @Transactional
    public void deleteAnswersFromProcessedTest() {
        ongoingTestAnswersRepository.deleteAllByOngoingTestEntity(ongoingTestEntity);
        ongoingTestsRepository.delete(ongoingTestEntity);
    }

    private List<FactorEntity> getFactorEntityList(TestResultsEntity testResultsEntity) {
        FactorEntity factorEntityD = new FactorEntity();
        factorEntityD.setFactor("D");
        factorEntityD.setFactorOrder(4);
        factorEntityD.setValue(testResultsEntity.getDFactor());

        FactorEntity factorEntityI = new FactorEntity();
        factorEntityI.setFactor("I");
        factorEntityI.setFactorOrder(3);
        factorEntityI.setValue(testResultsEntity.getIFactor());

        FactorEntity factorEntityS = new FactorEntity();
        factorEntityS.setFactor("S");
        factorEntityS.setFactorOrder(2);
        factorEntityS.setValue(testResultsEntity.getSFactor());

        FactorEntity factorEntityC = new FactorEntity();
        factorEntityC.setFactor("C");
        factorEntityC.setFactorOrder(1);
        factorEntityC.setValue(testResultsEntity.getCFactor());

        return List.of(factorEntityD, factorEntityI, factorEntityS, factorEntityC);
    }
}
