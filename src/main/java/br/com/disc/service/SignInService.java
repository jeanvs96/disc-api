package br.com.disc.service;

import br.com.disc.security.TokenService;
import br.com.disc.exceptions.AuthException;
import br.com.disc.model.dto.SignInRequestDTO;
import br.com.disc.model.dto.SignInWithAuthenticationCodeDTO;
import br.com.disc.model.dto.TokenDTO;
import br.com.disc.model.entity.AuthenticationCode;
import br.com.disc.model.entity.UserEntity;
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
