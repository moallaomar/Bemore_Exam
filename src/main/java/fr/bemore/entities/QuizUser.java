package fr.bemore.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class QuizUser implements Serializable {

    private static final long serialVersionUID = 5548L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private Quiz quiz;

    @OneToMany(mappedBy = "quizUser", cascade = CascadeType.ALL)
    private List<QuizAnswer> quizAnswers;

    public void addQuizAnswer(QuizAnswer quizAnswer) {
        if (this.quizAnswers == null) {
            this.quizAnswers = new ArrayList<>();
        }
        this.quizAnswers.add(quizAnswer);
    }

    private LocalDateTime passedDateTime;

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
}
