package fr.bemore.dao;

import fr.bemore.entities.Quiz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
public class QuizRepositoryTest {

    @Autowired
    QuizRepository quizRepository;


    Quiz quiz1 = new Quiz("Angular", "Google");
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void should_find_quiz_if_repository_is_empty() {
        Iterable<Quiz> quiz = quizRepository.findAll();

        assertThat(quiz).isNotEmpty();
    }

    @Test
    public void should_store_a_quiz() {

        Quiz quiz = quizRepository.save(quiz1);

        assertThat(quiz).hasFieldOrPropertyWithValue("name", "Angular");
        assertThat(quiz).hasFieldOrPropertyWithValue("description", "Google");
    }


    @Test
    public void getByName() {

        Quiz q1 = entityManager.find(Quiz.class, 2);
        q1.setCreatedDate(null);
        Quiz q = quizRepository.getQuizByName("Angular");
        q.setCreatedDate(null);
        assertEquals(q1, q);
    }

    @Test
    public void findTopByOrderByIdDesc() {

        entityManager.persist(quiz1);

        Quiz quiz2 = quizRepository.findTopByOrderByIdDesc();
        quiz2.setCreatedDate(null);
        assertEquals(quiz1, quiz2);
    }

    @Test
    public void findAll() {


        List<Quiz> q1 = new ArrayList<Quiz>();
        q1.add(entityManager.find(Quiz.class, 1));
        q1.add(entityManager.find(Quiz.class, 2));


        List<Quiz> qs = quizRepository.findAll();
        qs.forEach(a -> a.setCreatedDate(null));

        assertEquals(q1, qs);
    }

    @Test
    public void findById() {
        entityManager.persist(quiz1);
        Optional<Quiz> q = quizRepository.findById(quiz1.getId());
        q.get().setCreatedDate(null);
        assertEquals(quiz1, q.get());
    }


}
