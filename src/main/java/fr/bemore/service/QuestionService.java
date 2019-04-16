package fr.bemore.service;

import java.util.List;

import fr.bemore.entities.Question;

public interface QuestionService {

	 	public List<Question> findAll();
	 	
	 	public Question findById(Integer id);
	 	
	 	public int findAnswerIdCorrect(int questionId);
	 	
	 	public List<Question> findQuestionsByQuizId(Integer id);
	 	
}
