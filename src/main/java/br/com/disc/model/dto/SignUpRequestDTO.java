package br.com.disc.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SignUpRequestDTO {

    @NotEmpty
    private String username;

    @Schema(example = "admin@gmail.com")
    @NotNull
    @Email
    private String email;

    @NotEmpty
    private String password;

    private String city;

    private LocalDate birthDate;

    private String educationLevel;

    private String fieldOfInterest;
}
