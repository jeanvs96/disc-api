package br.com.disc.model.dto;

import br.com.disc.model.enums.EmailEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationCodeRequestDTO {
    private String email;
    private EmailEnum emailType;
}
