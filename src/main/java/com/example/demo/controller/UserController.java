package com.example.demo.controller;

import com.example.demo.model.dto.*;
import com.example.demo.service.UserService;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<TokenDTO> signUp(@RequestBody @Valid SignUpRequestDTO signUpRequestDTO) throws MessagingException, TemplateException, IOException {
        return new ResponseEntity<>(userService.signUp(signUpRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/logged/update-password")
    public ResponseEntity<String> updatePassword(UpdatePasswordDTO updatePasswordDTO) {
        return new ResponseEntity<>(userService.updateLoggedUserPassword(updatePasswordDTO), HttpStatus.OK);
    }

    @PutMapping("/code/update-password")
    public ResponseEntity<String> updatePasswordWithAuthenticationCode(@RequestBody UpdatePasswordWithCodeDTO updatePasswordWithCodeDTO) {
        userService.updatePasswordWithAuthenticationCode(updatePasswordWithCodeDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/first-name")
    public ResponseEntity<UserDTO> getUserFirstName() {
        return new ResponseEntity<>(userService.getUserFirstName(), HttpStatus.OK);
    }

    @PutMapping("/confirm-email")
    public ResponseEntity<TokenDTO> confirmEmail() {
        return new ResponseEntity<>(userService.confirmUserEmail(), HttpStatus.ACCEPTED);
    }

}
