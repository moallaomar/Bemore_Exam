package fr.bemore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.bemore.entities.Question;
import fr.bemore.service.QuestionService;


@RestController
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	@ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/questions" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Question>> findAll() {
		List<Question> questions =  questionService.findAll();
		 return ResponseEntity.ok().body(questions);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/question/{id}")
	public ResponseEntity<Question> findById(@PathVariable("id") Integer id){
		Question question = questionService.findById(id);
		return ResponseEntity.ok().body(question);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/correctanswer/{id}")
	public int findAnswerIdCorrect(@PathVariable("id")int questionId) {
	int answerId = questionService.findAnswerIdCorrect(questionId);
	return answerId;
	}
	

	
}
