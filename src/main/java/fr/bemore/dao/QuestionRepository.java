package fr.bemore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.bemore.entities.Question;

@Repository("questionRepository")
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	public List<Question> findAll();
	public Optional<Question> findById(Integer id) ;
	
	
		@Query("select q from Question q join q.quiz z where z.id = :x")
		List<Question> findQuestionsByQuizId(@Param("x") Integer x);

}
