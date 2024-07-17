package br.com.disc.controller;

import br.com.disc.model.dto.OngoingTestAnswerDTO;
import br.com.disc.service.AnswerService;
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
