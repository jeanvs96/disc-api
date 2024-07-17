package br.com.disc.model.dto;

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
