package com.example.demo.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {
    private Integer questionId;
    private String question;
    private List<AnswerDTO> answers;
}
