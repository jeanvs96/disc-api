package com.example.demo.model.dto;

import com.example.demo.model.enums.EmailEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationCodeRequestDTO {
    private String email;
    private EmailEnum emailType;
}
