package fr.bemore.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an association between User and quiz to see all the taken exams.
 *
 * @author Omar Moalla
 * @version 1.0
 */
@Entity
public class QuizUser implements Serializable {

    private static final long serialVersionUID = 5548L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Quiz quiz;

    @OneToMany(mappedBy = "quizUser", cascade = CascadeType.ALL)
    private List<QuizAnswer> quizAnswers;


    @Column
    private Integer score;

    @Column
    private Integer nbQuestion;


    private LocalDateTime passedDateTime;



    /** Creates a quizanswer object for each  quizUser object creation.
     * @param quizAnswer, the description of the quiz.
     */
    public void addQuizAnswer(QuizAnswer quizAnswer) {
        if (this.quizAnswers == null) {
            this.quizAnswers = new ArrayList<>();
        }
        this.quizAnswers.add(quizAnswer);
    }
    /** GETTERS & SETTERS
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public LocalDateTime getPassedDateTime() {
        return passedDateTime;
    }

    public void setPassedDateTime(LocalDateTime passedDateTime) {
        this.passedDateTime = passedDateTime;
    }

    @JsonManagedReference
    public List<QuizAnswer> getQuizAnswers() {
        return quizAnswers;
    }

    public void setQuizAnswers(List<QuizAnswer> quizAnswers) {
        this.quizAnswers = quizAnswers;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getNbQuestion() {
        return nbQuestion;
    }

    public void setNbQuestion(Integer nbQuestion) {
        this.nbQuestion = nbQuestion;
    }
}
