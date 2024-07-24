package br.com.disc.controller;

import br.com.disc.exceptions.AuthException;
import br.com.disc.model.dto.SignInRequestDTO;
import br.com.disc.model.dto.SignInWithAuthenticationCodeDTO;
import br.com.disc.model.dto.TokenDTO;
import br.com.disc.service.SignInService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sign-in")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final SignInService loginService;

    @PostMapping()
    public ResponseEntity<TokenDTO> signIn(@RequestBody @Valid SignInRequestDTO loginRequestDTO) throws JsonProcessingException {
        return new ResponseEntity<>(loginService.signIn(loginRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/code")
    public ResponseEntity<TokenDTO> signInWithAuthenticationCode(@RequestBody @Valid SignInWithAuthenticationCodeDTO loginRequestDTO) throws AuthException, JsonProcessingException {
        return new ResponseEntity<>(loginService.signInWithAuthenticationCode(loginRequestDTO), HttpStatus.OK);
    }

}
