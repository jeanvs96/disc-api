package com.example.demo.controller;

import com.example.demo.model.dto.TestDTO;
import com.example.demo.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Validated
public class TestController {
    private final TestService testService;

    @GetMapping("/{test_id}/{ongoing_test}")
    public ResponseEntity<TestDTO> getTest(@PathVariable(name = "test_id") String testId, @PathVariable(name = "ongoing_test") String ongoingTest) throws InterruptedException {
        Boolean ongoingTestBoolean = Boolean.valueOf(ongoingTest);
        return new ResponseEntity<>(testService.getTest(testId, ongoingTestBoolean), HttpStatus.OK);
    }

    @GetMapping("/check-ongoing-test")
    public ResponseEntity<Boolean> getTest() throws InterruptedException {
        return new ResponseEntity<>(testService.checkIfUserHasAnOngoingTest(), HttpStatus.OK);

    }

    @DeleteMapping("/delete-ongoing-test")
    public ResponseEntity<?> deleteOngoingTest() {
        testService.deleteOngoingTest();
        return ResponseEntity.noContent().build();
    }
}
