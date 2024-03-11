package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TestDTO {
    private Long testId;
    private List<QuestionDTO> questions;
    private Boolean isAnOngoingTest;
    private Integer currentQuestion;
}
