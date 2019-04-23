package fr.bemore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bemore.dao.QuestionRepository;
import fr.bemore.entities.Answer;
import fr.bemore.entities.Question;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> findAll() {

		return questionRepository.findAll();
	}

	@Override
	public int findAnswerIdCorrect(int questionId) {
		Question question = questionRepository.findById(questionId).get();
		for (Answer answer : question.getAnswers()) {
			if (answer.isCorrect()) {
				return answer.getId();
			}
		}
		return -1;
	}

	@Override
	public Question findById(Integer id) {
		Optional<Question> optQues = questionRepository.findById(id);
		return optQues.get();
	}

	@Override
	public List<Question> findQuestionsByQuizId(Integer id) {
		List<Question> questions = questionRepository.findQuestionsByQuizId(id);
		return questions;
	}

	@Override
	public Question addQuestion(Question question) {
		Question q = questionRepository.save(question);
		return q;
	}

	@Override
	public void deleteById(Integer id) {
		questionRepository.deleteById(id);
		System.out.println("deleted");
	}

	@Override
	public Integer countNbQuestion() {
		List<Question> questions = questionRepository.findAll();
		return questions.size();
	}

}
