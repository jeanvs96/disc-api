package br.com.disc.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PayerIdentificationDTO {

    private String type;
    private String number;
}
