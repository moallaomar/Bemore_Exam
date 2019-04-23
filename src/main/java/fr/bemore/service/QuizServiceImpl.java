package fr.bemore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.bemore.dao.QuizRepository;
import fr.bemore.entities.Quiz;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;

	@Override
	public List<Quiz> findAll() {
		List<Quiz> quizes = quizRepository.findAll();
		return quizes;
	}

	@Override
	public boolean save(Quiz quiz) {
		quizRepository.save(quiz);
		return true;
	}

	@Override
	public Quiz findLastQuiz() {
		Quiz quiz = quizRepository.findTopByOrderByIdDesc();
		return quiz;
	}

	@Override
	public boolean isQuizName(String name) {
		if (quizRepository.getQuizByName(name) == null) {
			return false;
		}
		return true;
	}

}
