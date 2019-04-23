package fr.bemore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.bemore.entities.Answer;
import fr.bemore.entities.Question;
import fr.bemore.service.AnswerService;
import fr.bemore.service.QuestionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@Autowired
	private QuestionService questionService;

	@PostMapping("/answer/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Answer> saveAnswer(@PathVariable("id") Integer id, @RequestBody Answer answer) {
		Question question = questionService.findById(id);
		answer.setQuestion(question);
		Answer ans = answerService.saveAnswer(answer);
		return ResponseEntity.ok().body(ans);
	}

	@GetMapping("/answer/count")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Integer> countQuestions() {
		Integer nb = answerService.countNbAnswer();
		return ResponseEntity.ok().body(nb);
	}

	@GetMapping("/answer/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Answer>> getAnswersByQuestionId(@PathVariable("id") Integer id) {
		List<Answer> answers = new ArrayList<Answer>();
		answers = answerService.GetAnswerByQuestionId(id);
		if (answers.isEmpty()) {
			return ResponseEntity.ok().body(new ArrayList<Answer>());
		}

		return ResponseEntity.ok().body(answers);
	}
	
	@DeleteMapping("/answer/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteAnswerById(@PathVariable Integer id){
				answerService.deleteById(id);
				return ResponseEntity.ok().body("DELETED");
	}

}
