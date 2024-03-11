package com.example.demo.service;

import com.example.demo.exceptions.AuthException;
import com.example.demo.model.dto.SignInRequestDTO;
import com.example.demo.model.dto.SignInWithAuthenticationCodeDTO;
import com.example.demo.model.dto.TokenDTO;
import com.example.demo.model.entity.AuthenticationCode;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInService {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final AuthenticationCodeService authenticationCodeService;
    @Value("${jwt.expiration}")
    private String expiration;
    public TokenDTO signIn(SignInRequestDTO loginRequestDTO) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
            new UsernamePasswordAuthenticationToken(
                    loginRequestDTO.getEmail(),
                    loginRequestDTO.getPassword()
            );

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        return tokenService.getToken((UserEntity) authentication.getPrincipal(), expiration);
    }

    public TokenDTO signInWithAuthenticationCode(SignInWithAuthenticationCodeDTO signInWithAuthenticationCodeDTO) throws AuthException {
        AuthenticationCode authenticationCode = authenticationCodeService.findByCode(signInWithAuthenticationCodeDTO.getCode());

        if (authenticationCode.getUserEntity().getEmail().equals(signInWithAuthenticationCodeDTO.getEmail())) {
            return tokenService.getToken(authenticationCode.getUserEntity(), expiration);
        }

        throw new AuthException("Invalid Authentication Code");
    }
}
