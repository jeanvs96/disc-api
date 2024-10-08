package br.com.disc.controller;

import br.com.disc.model.dto.CityDTO;
import br.com.disc.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/{state}")
    public ResponseEntity<List<CityDTO>> getAllById(@PathVariable String state) {
        return new ResponseEntity<>(cityService.findAllByStateName(state), HttpStatus.OK);
    }
}
