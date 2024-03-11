package com.example.demo.model.dto;

import com.example.demo.model.entity.FactorCombinationEntity;
import jakarta.persistence.Column;
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
}
