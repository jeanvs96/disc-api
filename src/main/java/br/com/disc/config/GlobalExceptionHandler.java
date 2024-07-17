package br.com.disc.config;

import br.com.disc.exceptions.AuthException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ AuthenticationException.class, AuthException.class})
    public ResponseEntity<Object> handleAuthenticationException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Authentication denied", new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({ NoSuchElementException.class})
    public ResponseEntity<Object> handleNoSuchElementException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Failed loading data from DB", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
