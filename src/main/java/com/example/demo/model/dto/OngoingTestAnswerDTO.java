package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@JsonIgnoreProperties(ignoreUnknown = true)
public class OngoingTestAnswerDTO {
    private Integer questionId;
    private List<AnswerPositionDTO> answersPositions;
}
