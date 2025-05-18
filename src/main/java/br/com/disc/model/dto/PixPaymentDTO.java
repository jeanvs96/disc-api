package br.com.disc.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PixPaymentDTO {

    private BigDecimal transactionAmount;
    private String description;
    private PayerDTO payer;
}
