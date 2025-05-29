package br.com.disc.service;

import br.com.disc.model.dto.FeedbackDTO;
import br.com.disc.model.entity.FeedbackEntity;
import br.com.disc.model.entity.UserEntity;
import br.com.disc.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final UserService userService;

    public void saveFeedback(FeedbackDTO feedback) {
        UserEntity loggedUser = userService.getLoggedUser();

        feedbackRepository.save(FeedbackEntity
                .builder()
                        .comment(feedback.getComment())
                        .rating(feedback.getRating())
                        .userEntity(loggedUser)
                .build()
        );

    }
}
