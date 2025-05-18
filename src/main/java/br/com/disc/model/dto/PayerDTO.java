package br.com.disc.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PayerDTO {

    private String email;
    private String name;
    private PayerIdentificationDTO identification;
}
