package fr.bemore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.bemore.entities.Question;
import fr.bemore.entities.Quiz;
import fr.bemore.service.QuestionService;
import fr.bemore.service.QuizService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService QuizService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/questions", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Question>> findAll() {
		List<Question> questions = questionService.findAll();
		return ResponseEntity.ok().body(questions);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/question/{id}")
	public ResponseEntity<Question> findById(@PathVariable("id") Integer id) {
		Question question = questionService.findById(id);
		return ResponseEntity.ok().body(question);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/correctanswer/{id}")
	public int findAnswerIdCorrect(@PathVariable("id") int questionId) {
		int answerId = questionService.findAnswerIdCorrect(questionId);
		return answerId;
	}

	@PostMapping("/question/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Question> addQuestion(@PathVariable("id") Integer id, @RequestBody Question question) {

		Quiz quiz = QuizService.findById(id);
		question.setQuiz(quiz);
		Question q = questionService.addQuestion(question);
		System.out.println("added");
		return ResponseEntity.ok().body(q);
	}

	@DeleteMapping("/question/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteQuestionByContent(@PathVariable("id") Integer id) {
		questionService.deleteById(id);
		System.out.println("deleted");
	}

	@GetMapping("/question/count")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Integer> countQuestions() {
		Integer nb = questionService.countNbQuestion();
		return ResponseEntity.ok().body(nb);
	}
	

}
