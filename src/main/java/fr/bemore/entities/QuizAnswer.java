package fr.bemore.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class QuizAnswer implements Serializable {



    private static final long serialVersionUID = 2564L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private QuizUser quizUser;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer selectedAnswer;

    public QuizAnswer(QuizUser quizUser, Question question, Answer selectedAnswer) {
        this.quizUser = quizUser;
        this.question = question;
        this.selectedAnswer = selectedAnswer;
    }
    public QuizAnswer(){

    }

    @JsonBackReference
    public QuizUser getQuizUser() {
        return quizUser;
    }

    public void setQuizUser(QuizUser quizUser) {
        this.quizUser = quizUser;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(Answer selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
