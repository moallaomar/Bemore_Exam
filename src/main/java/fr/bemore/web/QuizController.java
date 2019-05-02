package fr.bemore.web;

import fr.bemore.entities.Question;
import fr.bemore.entities.Quiz;
import fr.bemore.entities.dto.AnswerDTO;
import fr.bemore.service.QuestionService;
import fr.bemore.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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

	@GetMapping(path="/getquiz/{id}")
	@ResponseStatus(HttpStatus.OK)
	public  ResponseEntity getById(@PathVariable("id") Integer id){
		Quiz quiz = quizService.findById(id);

		return ResponseEntity.ok(quiz);
	}


	@GetMapping(path = "/isquizname/{name}")
	@ResponseStatus(HttpStatus.OK)
	public boolean isQuizName(@PathVariable("name") String name) {
		return quizService.isQuizName(name);
	}

	@GetMapping("/quiz/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Question>> findQuestionsByQuizId(@PathVariable("id") Integer id, Principal principal) {
		if(quizService.userPassedQuiz(id, principal) != null){

			List<Question> q = null;
			return ResponseEntity.ok().body(q);
		}

		List<Question> questions = questionService.findQuestionsByQuizId(id);
		return ResponseEntity.ok().body(questions);
	}
	
	@DeleteMapping("/quiz/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void DeleteQuiz(@PathVariable("id") Integer id) {
		quizService.deleteById(id);
	}

	@PostMapping("/quiz/{id}/{score}")
	public void submitQuiz(@PathVariable("id") Integer id, Principal principal, @RequestBody List<AnswerDTO> answersDTO,
								@PathVariable("score") String score){
		quizService.submitQuiz(id,answersDTO,principal,score);
	}
}
