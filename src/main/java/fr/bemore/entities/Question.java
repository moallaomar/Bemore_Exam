package fr.bemore.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * This class represents a Question.
 * 
 * @author Omar Moalla
 * 
 * @version 1.0
 * 
 */
@Entity
@Table(name = "question")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Lob
	@Column(name = "content", nullable = false, length = 1000)
	private String content;

	/**
	 * Represents the Question's answers.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL)
	private List<Answer> answers;

	@Lob
	@Column(name = "content_fr", nullable = false, length = 1000)
	private String Content_fr;

	/**
	 * Each Question has a quiz_id .
	 */
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_id", nullable = false)
	private Quiz quiz;

	/**
	 * Creates a question with the specified param.
	 * 
	 * @param content, The content of the question.
	 */
	public Question(String content,String content_fr) {
		this.content = content; this.Content_fr = content_fr;
	}

	/**
	 * Creates a question without params.
	 */
	public Question() {
	}

	/**
	 * Gets the Question Id.
	 * 
	 * @return An Integer representing the Question id.
	 * 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the Question id.
	 * 
	 * @param id An Integer containing the question id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the Question's content.
	 * 
	 * @return A String representing the Question's content.
	 * 
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the question's content.
	 * 
	 * @param content A String containing the question's content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Gets the Question's answers.
	 * 
	 * @return A List of Answer representing the Question's answers.
	 * 
	 */
	@JsonManagedReference
	public List<Answer> getAnswers() {
		return answers;
	}

	/**
	 * Sets the Question's answers.
	 * 
	 * @param answers A List of Answer containing the Question's answers.
	 * 
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	/**
	 * Gets the Question's quiz.
	 * 
	 * @return A Quiz representing the Question's quiz.
	 * 
	 */
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public String getContent_fr() {
		return Content_fr;
	}

	public void setContent_fr(String content_fr) {
		Content_fr = content_fr;
	}
}
