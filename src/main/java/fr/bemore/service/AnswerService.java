package fr.bemore.service;

import fr.bemore.entities.Answer;

import java.util.List;

public interface AnswerService {

    public Answer saveAnswer(Answer answer);

    public Integer countNbAnswer();

    public List<Answer> GetAnswerByQuestionId(Integer x);

    public void deleteById(Integer id);

}
