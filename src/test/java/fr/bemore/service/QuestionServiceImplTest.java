package fr.bemore.service;

import fr.bemore.Exceptions.QuestionNotFoundException;
import fr.bemore.Exceptions.QuizNotFoundException;
import fr.bemore.dao.QuestionRepository;
import fr.bemore.entities.Answer;
import fr.bemore.entities.Question;
import fr.bemore.entities.Quiz;
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

public class QuestionServiceImplTest {

    @InjectMocks
    QuestionServiceImpl questionService;

    @Mock
    private QuestionRepository questionRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void findAll() {

        Question q = new Question("Q1", "Q1FR");
        Question q1 = new Question("Q2", "Q2FR");

        List<Question> questions = new ArrayList<Question>();
        questions.add(q);
        questions.add(q1);

        Mockito.when(questionRepository.findAll()).thenReturn(questions);

        assertThat(questionService.findAll()).isEqualTo(questions);


    }

    @Test
    public void findAnswerIdCorrect() throws QuestionNotFoundException {
        Question q = new Question("Q1", "Q1FR");
        q.setId(1);
        Answer ans = new Answer();
        ans.setContent("Answer 1");
        ans.setCorrect(true);
        ans.setId(1);
        Answer ans2 = new Answer();
        ans2.setContent("Answer 2");
        ans2.setCorrect(false);
        ans2.setId(2);
        List<Answer> answers = new ArrayList<Answer>();
        answers.add(ans);
        answers.add(ans2);
        q.setAnswers(answers);
        Optional<Question> question = Optional.of(q);


        Mockito.when(questionRepository.findById(q.getId())).thenReturn(question);

        assertThat(questionService.findAnswerIdCorrect(question.get().getId())).isEqualTo(ans.getId());


    }

    @Test
    public void findById() throws QuestionNotFoundException {

        Question q = new Question("Q1", "Q1FR");
        q.setId(1);
        Optional<Question> question = Optional.of(q);

        Mockito.when(questionRepository.findById(question.get().getId())).thenReturn(question);
        assertThat(questionService.findById(question.get().getId())).isEqualTo(question.get());
    }

    @Test
    public void findQuestionsByQuizId() throws QuizNotFoundException {
        Quiz quiz = new Quiz("Java", "Oracle");
        quiz.setId(1);
        Question question = new Question("Q1", "Q1FR");
        question.setId(1);
        Question question1 = new Question("Q2", "Q2FR");
        question.setId(2);
        List<Question> questions = new ArrayList<Question>();
        questions.add(question);
        questions.add(question1);
        quiz.setQuestions(questions);
        Mockito.when(questionRepository.findQuestionsByQuizId(quiz.getId())).thenReturn(questions);

        assertThat(questionService.findQuestionsByQuizId(quiz.getId())).isEqualTo(questions);
    }

    @Test
    public void addQuestion() {
        Question question = new Question("Q1", "Q1FR");
        question.setId(1);
        Mockito.when(questionRepository.save(question)).thenReturn(question);
        assertThat(questionService.addQuestion(question)).isEqualTo(question);
    }

    @Test
    public void countNbQuestion() {
        Question question = new Question("Q1", "Q1FR");
        question.setId(1);
        Question question1 = new Question("Q2", "Q2FR");
        question.setId(2);
        Question question2 = new Question("Q3", "Q3FR");
        question.setId(3);
        List<Question> questions = new ArrayList<Question>();
        questions.add(question);
        questions.add(question1);
        questions.add(question2);

        Mockito.when(questionRepository.findAll()).thenReturn(questions);

        assertThat(questionService.countNbQuestion()).isEqualTo(questions.size());

    }
}
