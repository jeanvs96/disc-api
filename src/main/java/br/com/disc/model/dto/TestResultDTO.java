package br.com.disc.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TestResultDTO {
    private Integer dFactor;

    private Integer iFactor;

    private Integer sFactor;

    private Integer cFactor;

    private Date testDate;

    private List<FactorCombinationDTO> factorCombinations;

    private MainFactorDTO mainFactor;
}
