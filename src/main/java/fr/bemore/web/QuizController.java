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
public class QuizController {

	@Autowired
	private QuizService quizService;

	@Autowired
	private QuestionService questionService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/quiz")
	public ResponseEntity<List<Quiz>> findAll() {
		List<Quiz> quizes = quizService.findAll();
		return ResponseEntity.ok().body(quizes);

	}

	@PostMapping(path = "/quiz", produces = MediaType.APPLICATION_JSON_VALUE, consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public boolean createQuiz(@RequestBody Quiz quiz) {
		quizService.save(quiz);
		System.out.println("Quiz ajouté avec succès !");
		return true;
	}

	@GetMapping(path = "/lastquiz")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Quiz> findLastQuiz() {
		Quiz quiz = quizService.findLastQuiz();
		System.out.println(quiz);
		return ResponseEntity.ok().body(quiz);
	}

	@GetMapping(path = "/isquizname/{name}")
	@ResponseStatus(HttpStatus.OK)
	public boolean isQuizName(@PathVariable("name") String name) {
		return quizService.isQuizName(name);
	}

	@GetMapping("/quiz/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Question>> findQuestionsByQuizId(@PathVariable("id") Integer id) {
		List<Question> questions = questionService.findQuestionsByQuizId(id);
		return ResponseEntity.ok().body(questions);
	}
	
	@DeleteMapping("/quiz/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void DeleteQuiz(@PathVariable("id") Integer id) {
		quizService.deleteById(id);
	}
}
