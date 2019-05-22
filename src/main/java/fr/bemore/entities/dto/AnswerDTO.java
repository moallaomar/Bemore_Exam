package fr.bemore.entities.dto;

import fr.bemore.entities.Answer;

public class AnswerDTO {
    private Integer questionId;
    private Integer answered;

    public AnswerDTO(){

    }
    public AnswerDTO(Integer questionId, Integer answered){
        this.answered = answered;
        this.questionId = questionId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswered() {
        return answered;
    }

    public void setAnswered(Integer answered) {
        this.answered = answered;
    }
}
