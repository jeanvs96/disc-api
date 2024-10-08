package br.com.disc.controller;

import br.com.disc.model.dto.FieldOfInterestDTO;
import br.com.disc.service.FieldOfInterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fields-of-interest")
@RequiredArgsConstructor
public class FieldOfInterestController {
    private final FieldOfInterestService fieldOfInterestService;

    @GetMapping
    public ResponseEntity<List<FieldOfInterestDTO>> getAll() {
        return new ResponseEntity<>(fieldOfInterestService.getAll(), HttpStatus.OK);
    }
}
