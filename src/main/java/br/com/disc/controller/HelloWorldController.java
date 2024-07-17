package br.com.disc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloWorldController {

    @GetMapping()
    public ResponseEntity<String> getUserTestsResults() {
        return new ResponseEntity<>("Amor, nosso backend tá online", HttpStatus.OK);
    }
}
