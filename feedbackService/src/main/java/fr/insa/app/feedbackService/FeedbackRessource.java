package fr.insa.app.feedbackService;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackRessource {

    private List<Feedback> feedbacks = new ArrayList<>();

    @PostMapping
    public Feedback createFeedback(@RequestBody FeedbackDto feedbackDto, @RequestParam int volunteerId, @RequestParam int userId) {
        Feedback feedback = new Feedback(volunteerId, userId, feedbackDto.getComments(), feedbackDto.getRating());
        feedbacks.add(feedback);
        return feedback;
    }

    @GetMapping
    public List<Feedback> getAllFeedbacks() {
        return feedbacks;
    }
}
