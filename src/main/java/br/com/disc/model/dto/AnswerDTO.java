package br.com.disc.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDTO {
    private Integer answerId;
    private String answer;
    private Integer position;
}
