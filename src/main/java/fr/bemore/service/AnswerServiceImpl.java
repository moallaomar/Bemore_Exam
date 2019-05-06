package fr.bemore.service;

import fr.bemore.dao.AnswerRepository;
import fr.bemore.entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Service("AnswerService")
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer saveAnswer(Answer answer) {
        Answer answ = answerRepository.save(answer);
        return answ;
    }

    @Override
    public Integer countNbAnswer() {
            List<Answer> answers = answerRepository.findAll();
            return answers.size();

    }

    @Override
    public List<Answer> GetAnswerByQuestionId(Integer x) {
        List<Answer> answers = new ArrayList<Answer>(0);

        answers = answerRepository.findAnswersByQuestionId(x);
        if (answers.isEmpty()) {
            return new ArrayList<Answer>();
        }

        return answers;
    }

    @Override
    public void deleteById(Integer id) {
        answerRepository.deleteById(id);

    }

    @Override
    public Answer findById(Integer id) throws NullPointerException {
        try {
            Answer ans = answerRepository.findById(id).get();
            return ans;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new Answer();
        }

    }
    public void isCorrect(Integer id) throws NullPointerException {

        try {
            Answer a = answerRepository.findById(id).get();
            a.setCorrect(true);
            System.out.println("Answer Setted to Correct !");
            answerRepository.save(a);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Answer not Found ! ");
        }
    }
    public void isIncorrect(Integer id) throws NullPointerException{
        try {
            Answer a = answerRepository.findById(id).get();
            a.setCorrect(false);
            answerRepository.save(a);

            System.out.println("Answer Setted to Incorrect!");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Answer not Found ! ");
        }
}



}
