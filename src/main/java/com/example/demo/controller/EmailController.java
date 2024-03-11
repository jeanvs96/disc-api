package com.example.demo.controller;

import com.example.demo.model.dto.AuthenticationCodeRequestDTO;
import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
@Validated
public class EmailController {
    private final EmailService emailService;
    private final UserService userService;

    @PostMapping("/authentication-code")
    public ResponseEntity<String> sendAuthenticationCodeEmail(@RequestBody @Valid AuthenticationCodeRequestDTO authenticationCodeRequestDTO) throws MessagingException, TemplateException, IOException {
        emailService.sendAuthenticationCodeEmail(authenticationCodeRequestDTO, userService.getUserByEmail(authenticationCodeRequestDTO.getEmail()));
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/account-confirmation")
    public ResponseEntity<String> sendAccountConfirmationEmail() throws MessagingException, TemplateException, IOException {
        emailService.sendAccountConfirmationEmail(userService.getLoggedUser());
        return ResponseEntity.noContent().build();
    }
}
