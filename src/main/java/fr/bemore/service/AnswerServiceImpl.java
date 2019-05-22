package fr.bemore.service;

import fr.bemore.Exceptions.AnswerNotFindException;
import fr.bemore.dao.AnswerRepository;
import fr.bemore.entities.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("AnswerService")
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer saveAnswer(Answer answer) {
        if (answer == null)
            throw new NullPointerException();

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


    public Answer findById(Integer id) throws AnswerNotFindException {

        Optional<Answer> ans = answerRepository.findById(id);
        if (!ans.isPresent())
            throw new AnswerNotFindException("Cannot find the answer : " + id);
        return ans.get();
    }

    public Answer isCorrect(Integer id, boolean correct) throws NullPointerException {

        try {
            Answer answer = answerRepository.findById(id).get();
            answer.setCorrect(correct);

            if (correct == true) {
                System.out.println("Answer Setted to Correct !");
            } else {
                System.out.println("Answer Setted to Incorrect !");
            }
            answerRepository.save(answer);
            return answer;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Answer not Found ! ");
            return  new Answer();
        }
    }




}
