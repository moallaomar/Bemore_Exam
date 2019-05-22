package fr.bemore.service;

import fr.bemore.Exceptions.QuizNotFoundException;
import fr.bemore.dao.*;
import fr.bemore.entities.*;
import fr.bemore.entities.dto.AnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private QuizService quizService;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizUserRepository quizUserRepository;
    @Autowired
    private QuizAnswerRepository quizAnswerRepository;

    @Override
    public List<Quiz> findAll() {
        List<Quiz> quizes = quizRepository.findAll();
        if (quizes.isEmpty())
            return new ArrayList<Quiz>();
        return quizes;
    }

    @Override
    public boolean save(Quiz quiz) throws NullPointerException {
        if (quiz == null)
            throw new NullPointerException();
        quizRepository.save(quiz);
        return true;
    }

    @Override
    public Quiz findLastQuiz() throws NullPointerException {
        Quiz quiz = quizRepository.findTopByOrderByIdDesc();
        if (quiz == null)
            throw new NullPointerException();
        return quiz;
    }

    @Override
    public boolean isQuizName(String name) {
        return quizRepository.getQuizByName(name) != null;
    }

    public void deleteById(Integer quizId) {
        quizRepository.deleteById(quizId);
    }

    @Override
    public Quiz findById(Integer id) throws QuizNotFoundException {
        Optional<Quiz> Quiz = quizRepository.findById(id);
        if (!Quiz.isPresent())
            throw new QuizNotFoundException("Cannot find the Quiz : " + id);
        return Quiz.get();

    }

    @Override
    public void submitQuiz(Integer quizId, List<AnswerDTO> answers, Principal principal, String score) throws QuizNotFoundException {
        AppUser appUser = accountService.loadUserByUsername(principal.getName());
        Quiz quiz = quizService.findById(quizId);

        QuizUser quizUser = new QuizUser();

        answers.forEach(answerDTO -> {
            Answer answer = null;
            if (answerDTO.getAnswered() != null) {
                answer = answerRepository.findById(answerDTO.getAnswered()).get();
            }
            Question question = questionRepository.findById(answerDTO.getQuestionId()).get();
            quizUser.addQuizAnswer(new QuizAnswer(quizUser, question, answer));
        });
        quizUser.setAppUser(appUser);
        quizUser.setQuiz(quiz);
        quizUser.setPassedDateTime(LocalDateTime.now());
        Integer s = Integer.parseInt(score);
        quizUser.setScore(s);
        Quiz q = quizService.findById(quizId);
        quizUser.setNbQuestion(q.getQuestions().size());
        quizUserRepository.save(quizUser);
    }

    @Override
    public QuizUser userPassedQuiz(Integer quizId, Principal principal) throws QuizNotFoundException {
        AppUser appUser = accountService.loadUserByUsername(principal.getName());
        Quiz quiz = quizService.findById(quizId);
        Optional<QuizUser> quizUser = quizUserRepository.findByAppUserAndQuiz(appUser, quiz);
        return quizUser.orElse(null);
    }


    public List<QuizAnswer> findQuizAnswerByQuizUser(Integer quizId, Principal principal) throws QuizNotFoundException {
        AppUser appUser = accountService.loadUserByUsername(principal.getName());
        Quiz quiz = quizService.findById(quizId);
        QuizUser quizUser = quizUserRepository.findByAppUserAndQuiz(appUser, quiz).get();
        List<QuizAnswer> quizAnswer = quizAnswerRepository.findByQuizUser(quizUser);
        return quizAnswer;

    }
}
