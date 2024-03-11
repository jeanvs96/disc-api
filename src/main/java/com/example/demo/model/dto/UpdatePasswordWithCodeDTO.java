package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePasswordWithCodeDTO {
    private String email;
    private String code;
    private String password;
    private String passwordConfirmation;
}
