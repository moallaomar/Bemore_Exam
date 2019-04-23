package fr.bemore.service;

import java.util.List;

import fr.bemore.entities.Answer;

public interface AnswerService {

	public Answer saveAnswer(Answer answer);

	public Integer countNbAnswer();

	public List<Answer> GetAnswerByQuestionId(Integer x);
	
	public void deleteById(Integer id);

}
