package fr.bemore.service;

import fr.bemore.Exceptions.AnswerNotFindException;
import fr.bemore.entities.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerService {

    public Answer saveAnswer(Answer answer);

    public Integer countNbAnswer();

    public List<Answer> GetAnswerByQuestionId(Integer x);

    public void deleteById(Integer id);

    public Answer findById(Integer id) throws AnswerNotFindException;

    public Answer isCorrect(Integer id,boolean correct) throws NullPointerException;




    }
