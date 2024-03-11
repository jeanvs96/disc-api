package com.example.demo.security;

import com.example.demo.config.GlobalExceptionHandler;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private final TokenService tokenService;
    private static final String BEARER = "Bearer ";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException, ExpiredJwtException {
        try {
            String token = getTokenFromHeader(request);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = tokenService.isValid(token);

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            filterChain.doFilter(request, response);
        } catch (RuntimeException e) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
    }

    private String getTokenFromHeader(HttpServletRequest header) {
        String token = header.getHeader("Authorization");
        if (token != null) {
            return token.replace(BEARER, "");
        }

        return null;
    }
}
