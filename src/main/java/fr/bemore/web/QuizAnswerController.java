package fr.bemore.web;


import fr.bemore.entities.QuizAnswer;
import fr.bemore.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuizAnswerController {


    @Autowired
    private QuizService quizService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/quizanswers/{id}")
    public ResponseEntity<List<QuizAnswer>> findQuizAnswerByQuizUser(@PathVariable("id") Integer id, Principal principal) {
        List<QuizAnswer> qa = quizService.findQuizAnswerByQuizUser(id, principal);
        return ResponseEntity.ok().body(qa);
    }


}
