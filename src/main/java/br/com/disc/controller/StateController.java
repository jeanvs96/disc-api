package br.com.disc.controller;

import br.com.disc.model.dto.StateDTO;
import br.com.disc.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/states")
@RequiredArgsConstructor
public class StateController {
    private final StateService stateService;

    @GetMapping()
    public ResponseEntity<List<StateDTO>> getAll() {
        return new ResponseEntity<>(stateService.getAll(), HttpStatus.OK);
    }
}
