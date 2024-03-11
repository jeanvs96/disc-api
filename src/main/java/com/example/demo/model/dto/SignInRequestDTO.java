package com.example.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequestDTO {
    @Schema(example = "96jeanvs@gmail.com")
    @NotEmpty
    private String email;

    @Schema
    @NotEmpty
    private String password;
}
