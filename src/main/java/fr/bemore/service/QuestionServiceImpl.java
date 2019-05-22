package fr.bemore.service;

import fr.bemore.Exceptions.QuestionNotFoundException;
import fr.bemore.Exceptions.QuizNotFoundException;
import fr.bemore.dao.QuestionRepository;
import fr.bemore.entities.Answer;
import fr.bemore.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<Question>();
        questions = questionRepository.findAll();
        if (questions.isEmpty())
            return new ArrayList<Question>();
        return questions;

    }

    @Override
    public int findAnswerIdCorrect(int questionId) throws QuestionNotFoundException {
        Optional<Question> question = questionRepository.findById(questionId);
        if(!question.isPresent())
            throw new QuestionNotFoundException("Cannot find the Question id : "+questionId);
        for (Answer answer : question.get().getAnswers()) {
            if (answer.isCorrect()) {
                return answer.getId();
            }
        }
        return -1;
    }

    @Override
    public Question findById(Integer id) throws  QuestionNotFoundException {
        Optional<Question> optQues = questionRepository.findById(id);
        if (!optQues.isPresent())
        throw new QuestionNotFoundException("Cannot find Question :"+id);
        return optQues.get();
    }

    @Override
    public List<Question> findQuestionsByQuizId(Integer id) throws  QuizNotFoundException {
        List<Question> questions = questionRepository.findQuestionsByQuizId(id);
        if (questions.isEmpty())
            throw new QuizNotFoundException("Cannot find the Quiz  :   "+id);
        return questions;
    }

    @Override
    public Question addQuestion(Question question)throws NullPointerException {
        if(question == null)
        throw  new NullPointerException("The question is Null : "+ question);
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
