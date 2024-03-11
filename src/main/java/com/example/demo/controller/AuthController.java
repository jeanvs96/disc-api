package com.example.demo.controller;

import com.example.demo.exceptions.AuthException;
import com.example.demo.model.dto.SignInRequestDTO;
import com.example.demo.model.dto.SignInWithAuthenticationCodeDTO;
import com.example.demo.model.dto.TokenDTO;
import com.example.demo.service.SignInService;
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
    public ResponseEntity<TokenDTO> signIn(@RequestBody @Valid SignInRequestDTO loginRequestDTO) {
        return new ResponseEntity<>(loginService.signIn(loginRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/code")
    public ResponseEntity<TokenDTO> signInWithAuthenticationCode(@RequestBody @Valid SignInWithAuthenticationCodeDTO loginRequestDTO) throws AuthException {
        return new ResponseEntity<>(loginService.signInWithAuthenticationCode(loginRequestDTO), HttpStatus.OK);
    }

}
