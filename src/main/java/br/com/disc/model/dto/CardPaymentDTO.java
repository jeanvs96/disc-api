package br.com.disc.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class CardPaymentDTO {

    private String token;
    private String issuerId;
    private String paymentMethodId;
    private BigDecimal transactionAmount;
    private Integer installments;
    private String description;
    private PayerDTO payer;
}
