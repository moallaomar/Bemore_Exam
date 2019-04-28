package fr.bemore.dao;

import fr.bemore.entities.AppUser;
import fr.bemore.entities.Quiz;
import fr.bemore.entities.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizUserRepository extends JpaRepository<QuizUser, Integer> {
    Optional<QuizUser> findByAppUserAndQuiz(AppUser appUser, Quiz quiz);
}
