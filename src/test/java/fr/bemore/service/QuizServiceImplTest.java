package fr.bemore.service;

import fr.bemore.Exceptions.QuizNotFoundException;
import fr.bemore.dao.QuizRepository;
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

public class QuizServiceImplTest {

    @InjectMocks
    QuizServiceImpl quizService;

    @Mock
    private QuizRepository quizRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void findAll() {
        Quiz quiz = new Quiz("Java", "Oracle");
        Quiz quiz1 = new Quiz("Angular", "Google");
        List<Quiz> quizes = new ArrayList<Quiz>();
        quizes.add(quiz);
        quizes.add(quiz1);

        Mockito.when(quizRepository.findAll()).thenReturn(quizes);

        assertThat(quizService.findAll()).isEqualTo(quizes);

    }

    @Test
    public void save() {

        Quiz quiz = new Quiz("Java", "Oracle");

        Mockito.when(quizRepository.save(quiz)).thenReturn(quiz);
        assertThat(quizService.save(quiz)).isTrue();

    }

    @Test
    public void findLastQuiz() {
        Quiz quiz = new Quiz("Java", "Oracle");
        Quiz quiz1 = new Quiz("Angular", "Google");
        List<Quiz> quizes = new ArrayList<Quiz>();
        quizes.add(quiz);
        quizes.add(quiz1);

        Mockito.when(quizRepository.findTopByOrderByIdDesc()).thenReturn(quizes.get(quizes.size() - 1));

        assertThat(quizService.findLastQuiz()).isEqualTo(quizes.get(quizes.size() - 1));


    }

    @Test
    public void isQuizName() {
        Quiz quiz = new Quiz("Java", "Oracle");
        Quiz quiz1 = new Quiz("Angular", "Google");

        Mockito.when(quizRepository.getQuizByName(quiz.getName())).thenReturn(quiz);

        if (quiz.getName() != null)
            assertThat(quizService.isQuizName(quiz.getName())).isTrue();
        if (quiz.getName() == null)
            assertThat(quizService.isQuizName(quiz.getName())).isFalse();
    }


    @Test
    public void findById() throws QuizNotFoundException {
        Quiz q1 = new Quiz("Java", "Oracle");
        q1.setId(1);
        Optional<Quiz> quiz = Optional.of(q1);

        Mockito.when(quizRepository.findById(q1.getId())).thenReturn(quiz);
        assertThat(quizService.findById(quiz.get().getId())).isEqualTo(quiz.get());
    }
}
