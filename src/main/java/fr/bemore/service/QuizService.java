package fr.bemore.service;

import java.util.List;

import fr.bemore.entities.Quiz;

public interface QuizService {

	public List<Quiz> findAll();

	public boolean save(Quiz quiz);

	public Quiz findLastQuiz();

	public boolean isQuizName(String name);
	
	public void deleteById(Integer quizId); 
}
