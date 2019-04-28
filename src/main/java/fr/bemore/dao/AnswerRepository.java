package fr.bemore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.bemore.entities.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {

	@SuppressWarnings("unchecked")
	public Answer save(Answer answer);

	public List<Answer> findAll();

	@Query("select a from Answer a join a.question q where q.id = :x")
	public List<Answer> findAnswersByQuestionId(@Param("x") Integer x);
	
	
	@Override
	public void deleteById(Integer id);

}
