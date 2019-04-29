package fr.bemore.service;

import fr.bemore.entities.Quiz;
import fr.bemore.entities.QuizAnswer;
import fr.bemore.entities.QuizUser;
import fr.bemore.entities.dto.AnswerDTO;

import java.security.Principal;
import java.util.List;

public interface QuizService {

    public List<Quiz> findAll();

    public boolean save(Quiz quiz);

    public Quiz findLastQuiz();

    public boolean isQuizName(String name);

    public void deleteById(Integer quizId);

    public Quiz findById(Integer id);

    public void submitQuiz(Integer quizId, List<AnswerDTO> answers, Principal principal);

    public QuizUser userPassedQuiz(Integer quizId, Principal principal);

    public List<QuizAnswer> findQuizAnswerByQuizUser(Integer quizId, Principal principal);

}
