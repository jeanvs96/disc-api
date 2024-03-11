package com.example.demo.security;

import com.example.demo.model.dto.TokenDTO;
import com.example.demo.model.entity.RolesEntity;
import com.example.demo.model.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;
    private static final String ROLES = "roles";
    private static final String BEARER = "Bearer ";

    public TokenDTO getToken(UserEntity userEntity, String expiration) {
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
