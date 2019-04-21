package fr.bemore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.bemore.entities.Quiz;

@Repository("quizRepository")
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

	public List<Quiz> findAll();
	public Optional<Quiz> findById(Integer id);
	
	public Quiz save(Quiz quiz);	
	
	public Quiz findTopByOrderByIdDesc();
	
	@Query("select q from Quiz q where q.name = :x")
	public Quiz getQuizByName(@Param("x") String x);

	
}
