package com.example.demo.controller;

import com.example.demo.model.dto.EducationLevelDTO;
import com.example.demo.service.EducationLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/education-levels")
@RequiredArgsConstructor
public class EducationLevelController {
    private final EducationLevelService educationLevelService;

    @GetMapping
    public ResponseEntity<List<EducationLevelDTO>> getAll() {
        return new ResponseEntity<>(educationLevelService.findAll(), HttpStatus.OK);
    }
}
