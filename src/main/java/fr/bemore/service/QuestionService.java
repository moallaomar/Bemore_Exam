package fr.bemore.service;

import fr.bemore.Exceptions.QuestionNotFoundException;
import fr.bemore.Exceptions.QuizNotFoundException;
import fr.bemore.entities.Question;

import java.util.List;

public interface QuestionService {

    public List<Question> findAll();

    public Question findById(Integer id) throws QuestionNotFoundException;

    public int findAnswerIdCorrect(int questionId) throws QuestionNotFoundException;

    public List<Question> findQuestionsByQuizId(Integer id) throws QuizNotFoundException;

    public Question addQuestion(Question question) throws NullPointerException;

    public Integer countNbQuestion();

    public void deleteById(Integer id);

}
