package fr.bemore.dao;

import fr.bemore.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    public List<Question> findAll();

    @SuppressWarnings("unchecked")
    public Question save(Question Question);

    public Optional<Question> findById(Integer id);

    @Query("select q from Question q join q.quiz z where z.id = :x")
    public List<Question> findQuestionsByQuizId(@Param("x") Integer x);

    @Override
    public void deleteById(Integer id);

}
