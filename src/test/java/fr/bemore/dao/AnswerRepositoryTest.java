package fr.bemore.dao;

import fr.bemore.entities.Answer;
import fr.bemore.entities.Question;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AnswerRepositoryTest {


    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private QuestionRepository questionRepository;


    @Test
    public void findAll() {
        List<Answer> answers = answerRepository.findAll();
        assertThat(!answers.isEmpty());
    }

    @Test
    public void save() {
        Answer answer = new Answer();
        answer.setContent("test");
        answer.setCorrect(false);
        Question q = entityManager.find(Question.class, 4);
        answer.setQuestion(q);
        Answer ans = answerRepository.save(answer);
        assertThat(answer).isEqualTo(ans);

    }

    @Test
    public void findAnswersByQuestionId() {
        Question question = questionRepository.findById(1).get();

        List<Answer> ans = answerRepository.findAnswersByQuestionId(1);
        assertThat(question.getAnswers().toArray()).isEqualTo(ans.toArray());
    }
    @Test
    public void findById()
    {
        Answer answer = answerRepository.findById(1).get();
        assertThat(answer).isNotNull();
    }


}
