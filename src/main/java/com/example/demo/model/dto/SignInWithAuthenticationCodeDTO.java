package com.example.demo.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInWithAuthenticationCodeDTO {
    @NotEmpty
    private String email;

    @NotEmpty
    private String code;
}
