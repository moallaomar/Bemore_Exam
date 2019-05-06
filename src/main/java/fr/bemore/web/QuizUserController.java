package fr.bemore.web;


import fr.bemore.entities.QuizUser;
import fr.bemore.service.QuizUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuizUserController {

    @Autowired
    private QuizUserService quizUserService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/quizuser")
    public ResponseEntity findAll() {
        List<QuizUser> qu = quizUserService.findAll();
        return ResponseEntity.ok().body(qu);

    }


}
