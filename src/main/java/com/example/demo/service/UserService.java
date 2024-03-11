package com.example.demo.service;

import com.example.demo.model.dto.*;
import com.example.demo.model.entity.*;
import com.example.demo.model.enums.EmailEnum;
import com.example.demo.model.enums.RoleNameEnum;
import com.example.demo.repository.RolesRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.TokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;
    private final SignInService signInService;
    private final RolesRepository rolesRepository;
    private final CityService cityService;
    private final EducationLevelService educationLevelService;
    private final FieldOfInterestService fieldOfInterestService;
    private final EmailService emailService;
    private final TokenService tokenService;
    private final AuthenticationCodeService authenticationCodeService;
    @Value("${jwt.expiration}")
    private String expiration;

    public TokenDTO signUp(SignUpRequestDTO signUpRequestDTO) throws MessagingException, TemplateException, IOException {
        UserEntity newUser = buildUserEntity(signUpRequestDTO);
        encodePassword(newUser);
        setNewUserDefaultRole(newUser);
        userRepository.save(newUser);

        emailService.sendAccountConfirmationEmail(newUser);

        return signInService.signIn(signUpRequestToSignInRequestDTO(signUpRequestDTO));
    }

    private UserEntity buildUserEntity(SignUpRequestDTO signUpRequestDTO) {
        return UserEntity.builder()
                .username(signUpRequestDTO.getUsername())
                .email(signUpRequestDTO.getEmail())
                .password(signUpRequestDTO.getPassword())
                .status(true)
                .cityEntity(!"".equals(signUpRequestDTO.getCity()) ? cityService.findByName(signUpRequestDTO.getCity()) : null)
                .birthDate(signUpRequestDTO.getBirthDate())
                .educationLevelEntity(!"".equals(signUpRequestDTO.getEducationLevel()) ? educationLevelService.findByEducationLevel(signUpRequestDTO.getEducationLevel()) : null)
                .fieldOfInterestEntity(!"".equals(signUpRequestDTO.getFieldOfInterest())? fieldOfInterestService.findByField(signUpRequestDTO.getFieldOfInterest()) : null)
                .build();
    }

    public String updateLoggedUserPassword(UpdatePasswordDTO updatePasswordDTO) {
        UserEntity loggedUser = getLoggedUser();
        if (passwordEncoder.matches(updatePasswordDTO.getOldPassword(),
                getLoggedUser().getPassword())) {
            loggedUser.setPassword(passwordEncoder.encode(updatePasswordDTO.getNewPassword()));

            userRepository.save(loggedUser);
            return "Senha atualizada com sucesso";
        } else {
            return "Senha incorreta";
        }
    }

    public String updatePasswordWithAuthenticationCode(UpdatePasswordWithCodeDTO updatePasswordWithCodeDTO) {
        AuthenticationCode authenticationCode = authenticationCodeService.findByCode(updatePasswordWithCodeDTO.getCode());
        if (authenticationCodeService.isAuthenticationCodeValid(authenticationCode)
                && updatePasswordWithCodeDTO.getPassword().equals(updatePasswordWithCodeDTO.getPasswordConfirmation())
                && authenticationCode.getUserEntity().getEmail().equals(updatePasswordWithCodeDTO.getEmail())) {
            authenticationCode.getUserEntity().setPassword(passwordEncoder.encode(updatePasswordWithCodeDTO.getPassword()));
            userRepository.save(authenticationCode.getUserEntity());
        }
        return "";
    }

    public TokenDTO confirmUserEmail() {
        UserEntity userEntity = getLoggedUser();
        userEntity.getRolesEntities().add(rolesRepository.findByRoleName(RoleNameEnum.VERIFIED_USER.name()));

        userRepository.save(userEntity);

        return tokenService.getToken(userEntity, expiration);
    }

    public UserDTO getUserFirstName() {
        UserEntity userEntity = getLoggedUser();
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(userEntity.getUsername().split(" ")[0]);
        return userDTO;
    }

    public UserEntity getLoggedUser() throws NoSuchElementException {
        Integer idLoggedUser = getIdLoggedUser();
        Optional<UserEntity> loggedUser = userRepository.findById(idLoggedUser);
        return loggedUser.orElseThrow();
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public Integer getIdLoggedUser() {
        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return (Integer) principal;
    }

    public void encodePassword(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
    }

    private void setNewUserDefaultRole(UserEntity userEntity) {
        Set<RolesEntity> rolesEntities = new HashSet<>();
        rolesEntities.add(rolesRepository.findByRoleName(RoleNameEnum.USER.name()));

        userEntity.setRolesEntities(rolesEntities);
    }

    private SignInRequestDTO signUpRequestToSignInRequestDTO(SignUpRequestDTO signUpRequestDTO) {
        return objectMapper.convertValue(signUpRequestDTO, SignInRequestDTO.class);
    }
}
