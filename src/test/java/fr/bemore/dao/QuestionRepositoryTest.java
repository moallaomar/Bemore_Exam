package fr.bemore.dao;

import fr.bemore.entities.Question;
import fr.bemore.entities.Quiz;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionRepositoryTest {
    @Autowired
    QuestionRepository questionRepository;
    Quiz quiz = new Quiz("Java", "Oracle");
    Question q = new Question("Whats POO", "Definir La POO");
    Question q1 = new Question("Question 2", "Q2");
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private QuizRepository quizRepository;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void should_find_questions_if_repository_is_empty() {
        List<Question> questions = questionRepository.findAll();
        assertThat(questions).isNotEmpty();
    }

    @Test
    public void findQuestionsByQuizId() {
        Quiz quiz = quizRepository.getQuizByName("Java");
        List<Question> qs = questionRepository.findQuestionsByQuizId(quiz.getId());
        assertEquals(quiz.getQuestions().toArray(), qs.toArray());
    }

    @Test
    public void should_store_a_question() {
        entityManager.persist(quiz);
        q.setQuiz(quiz);
        Question question = questionRepository.save(q);
        assertThat(question).hasFieldOrPropertyWithValue("content", "Whats POO");
        assertThat(question).hasFieldOrPropertyWithValue("Content_fr", "Definir La POO");
    }

    @Test
    public void findById() {

       Question q = entityManager.find(Question.class,1);

        Question question = questionRepository.findById(q.getId()).get();

        assertEquals(q, question);

    }




}
