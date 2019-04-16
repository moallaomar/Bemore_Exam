package fr.bemore.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name= "answer")
public class Answer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 148L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = false, unique = true)
	private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="question_id", nullable = false)
	private Question question;
	@Lob
	@Column(name="content",nullable = false,length = 1000)
	private String content;
	
	@Column(name="correct", nullable = false)
	private boolean correct;
	
	public Answer() {
		
	}
	
	public Answer(Question question,String content, boolean correct) {
		this.question = question;
		this.content = content;
		this.correct = correct;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@JsonBackReference
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	

}
