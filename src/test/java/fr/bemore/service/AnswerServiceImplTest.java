package fr.bemore.service;

import fr.bemore.Exceptions.AnswerNotFindException;
import fr.bemore.dao.AnswerRepository;
import fr.bemore.dao.QuestionRepository;
import fr.bemore.entities.Answer;
import fr.bemore.entities.Question;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerServiceImplTest {


    @InjectMocks
    AnswerServiceImpl answerService;

    @Mock
    private AnswerRepository answerRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void saveAnswer() {
        Answer ans = new Answer();
        ans.setContent("Answer 1");
        ans.setQuestion(new Question("Q1", "Q1FR"));
        Mockito.when(answerRepository.save(ans)).thenReturn(ans);
        assertThat(answerService.saveAnswer(ans)).isEqualTo(ans);
    }

    @Test
    public void countNbAnswer() {
        Answer ans = new Answer();
        ans.setContent("Answer 1");
        ans.setQuestion(new Question("Q1", "Q1FR"));
        Answer ans1 = new Answer();
        ans1.setContent("Answer 2");
        ans1.setQuestion(new Question("Q2", "Q2FR"));
        List<Answer> answers = new ArrayList<Answer>();
        Mockito.when(answerRepository.saveAll(answers)).thenReturn(answers);
        assertThat(answerService.countNbAnswer()).isEqualTo(answers.size());


    }

    @Test
    public void getAnswerByQuestionId() {
        List<Answer> answers = new ArrayList<Answer>();
        Optional<Question> question1 = Optional.empty();
        Question question = new Question("q1", "q1fr");
        question.setId(1);
        Answer ans1 = new Answer();
        ans1.setContent("Answer 2");
        ans1.setQuestion(new Question("Q2", "Q2FR"));
        Answer ans = new Answer();
        ans.setContent("Answer 1");
        answers.add(ans);
        answers.add(ans1);

        Mockito.when(answerRepository.findAnswersByQuestionId(question.getId())).thenReturn(answers);

        assertThat(answerService.GetAnswerByQuestionId(question.getId())).isEqualTo(answers);

    }


    @Test
    public void findById() throws AnswerNotFindException {
        Answer ans = new Answer();
        ans.setContent("Answer 1");
        Answer ans1 = new Answer();
        ans1.setContent("Answer 2");
        Question question = new Question("Q2", "Q2FR");
        question.setId(1);
        ans1.setQuestion(question);
        ans.setQuestion(question);
        Optional<Answer> answer = Optional.of(ans1);
        Mockito.when(answerRepository.findById(ans1.getId())).thenReturn(answer);

        assertThat(answerService.findById(ans1.getId())).isEqualTo(answer.get());

    }

    @Test
    public void SetIsCorrect() {
        Answer ans = new Answer();
        ans.setId(1);
        ans.setContent("Answer 1");
        ans.setCorrect(true);
        Optional<Answer> answer = Optional.of(ans);

        Mockito.when(answerRepository.findById(ans.getId())).thenReturn(answer);
        Mockito.when(answerRepository.save(answer.get())).thenReturn(answer.get());
        Assert.assertEquals(answerService.isCorrect(answer.get().getId(),answer.get().isCorrect()),answer.get());


    }
}
