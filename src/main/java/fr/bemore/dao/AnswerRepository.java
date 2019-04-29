package fr.bemore.dao;

import fr.bemore.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

    @SuppressWarnings("unchecked")
    Answer save(Answer answer);

    List<Answer> findAll();

    @Query("select a from Answer a join a.question q where q.id = :x")
    List<Answer> findAnswersByQuestionId(@Param("x") Integer x);


    @Override
    void deleteById(Integer id);

}
