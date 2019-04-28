package fr.bemore.dao;


import fr.bemore.entities.QuizAnswer;
import fr.bemore.entities.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAnswerRepository extends JpaRepository<QuizAnswer,Integer> {

    List<QuizAnswer> findByQuizUser(QuizUser quizUser);


}
