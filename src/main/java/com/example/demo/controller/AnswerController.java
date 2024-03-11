package com.example.demo.controller;

import com.example.demo.model.dto.OngoingTestAnswerDTO;
import com.example.demo.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/save")
    public void saveAnswer(@RequestBody OngoingTestAnswerDTO ongoingTestAnswerDTO) {
        answerService.saveAnswer(ongoingTestAnswerDTO);
    }

    @PutMapping("/update")
    public void updateAnswer(@RequestBody OngoingTestAnswerDTO ongoingTestAnswerDTO) {
        answerService.updateAnswer(ongoingTestAnswerDTO);
    }
}
