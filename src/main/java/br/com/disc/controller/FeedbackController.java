package br.com.disc.controller;

import br.com.disc.model.dto.FeedbackDTO;
import br.com.disc.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping()
    public ResponseEntity<Boolean> saveFeedback(@RequestBody FeedbackDTO feedback) {
        feedbackService.saveFeedback(feedback);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
