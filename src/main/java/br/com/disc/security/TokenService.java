package br.com.disc.security;

import br.com.disc.model.dto.TokenDTO;
import br.com.disc.model.entity.RolesEntity;
import br.com.disc.model.entity.UserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;
    private static final String ROLES = "roles";
    private static final String BEARER = "Bearer ";
    private final ObjectMapper objectMapper;

    public TokenDTO getToken(UserEntity userEntity, String expiration) throws JsonProcessingException {
        log.info("GENERATE TOKEN: " + objectMapper.writeValueAsString(userEntity));
        Date now = new Date();
        Date tokenExpirationDate = new Date(now.getTime() + Long.parseLong(expiration));

        List<String> userRoles = userEntity.getRolesEntities().stream().map(RolesEntity::getRoleName).toList();

        String token = Jwts.builder()
                .setIssuer("")
                .claim(Claims.ID, userEntity.getUserId())
                .claim(ROLES, userRoles).setIssuedAt(now)
                .setExpiration(tokenExpirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        log.info("GENERATED TOKEN: " + objectMapper.writeValueAsString(token));

        return new TokenDTO(BEARER + token);
    }

    public UsernamePasswordAuthenticationToken isValid(String token) throws ExpiredJwtException {
        if (token != null) {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            Integer idUser = body.get(Claims.ID, Integer.class);

            if (idUser != null) {
                List<String> roles = body.get(ROLES, List.class);

                List<SimpleGrantedAuthority> grantedAuthorities = roles.stream().map(SimpleGrantedAuthority::new).toList();

                return new UsernamePasswordAuthenticationToken(idUser, null, grantedAuthorities);
            }
        }
        return null;
    }
}
