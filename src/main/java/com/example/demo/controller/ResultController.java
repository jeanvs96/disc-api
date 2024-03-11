package com.example.demo.controller;

import com.example.demo.model.dto.TestResultDTO;
import com.example.demo.model.entity.TestResultsEntity;
import com.example.demo.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/results")
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;

    @PostMapping()
    public ResponseEntity<TestResultsEntity> finishTest() {
        return new ResponseEntity<>(resultService.processFinishedTestResult(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<TestResultDTO>> getUserTestsResults() {
        return new ResponseEntity<>(resultService.getUserTestsResults(), HttpStatus.OK);
    }
}
