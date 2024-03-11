package com.example.demo.service;

import com.example.demo.exceptions.AuthException;
import com.example.demo.model.entity.AuthenticationCode;
import com.example.demo.model.entity.UserEntity;
import com.example.demo.repository.AuthenticationCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthenticationCodeService {
    private final AuthenticationCodeRepository authenticationCodeRepository;

    public AuthenticationCode getAuthenticationCode(UserEntity userEntity) {
        AuthenticationCode authenticationCode = new AuthenticationCode();
        authenticationCode.setCode(generateAuthenticationCode(userEntity));
        authenticationCode.setUserEntity(userEntity);
        authenticationCode.setTimestamp(LocalDateTime.now());

        return authenticationCodeRepository.save(authenticationCode);
    }

    public AuthenticationCode findByCode(String code) throws AuthException {
        AuthenticationCode authenticationCode;
        try {
             authenticationCode = authenticationCodeRepository.findByCode(code).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new AuthException("Unable To Find Authentication Code");
        }

        authenticationCodeRepository.delete(authenticationCode);

        if(isAuthenticationCodeValid(authenticationCode)) {
            return authenticationCode;
        }

        throw new AuthException("Authentication Code Expired");
    }

    private String generateAuthenticationCode(UserEntity userEntity) {
        LocalTime localTime = LocalTime.now();

        List<Character> userFirstAndLastCharacters = getUsernameFirstAndLastChars(userEntity);

        String minutes = parseTimeToString(localTime.getMinute());
        String seconds = parseTimeToString(localTime.getSecond());

        return userFirstAndLastCharacters.get(0) + seconds + userFirstAndLastCharacters.get(1) + minutes;
    }

    private List<Character> getUsernameFirstAndLastChars(UserEntity userEntity) {
        List<Character> characters = new ArrayList<>();
        String username = userEntity.getUsername().strip().split(" ")[0].toUpperCase();

        characters.add(username.charAt(0));
        characters.add(username.charAt(username.length() - 1));

        return characters;
    }

    private String parseTimeToString(Integer time) {
        String parsedTime = "";

        if (time < 10) {
            parsedTime = "0" + String.valueOf(time);
        } else {
            parsedTime = String.valueOf(time);
        }

        return parsedTime;
    }

    public boolean isAuthenticationCodeValid(AuthenticationCode authenticationCode) {
        return authenticationCode.getTimestamp().plusMinutes(30L).isAfter(LocalDateTime.now());
    }
}
