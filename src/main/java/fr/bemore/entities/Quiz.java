package fr.bemore.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/** This class  represents a quiz.
 * @author Omar Moalla
 * 
 * @version 1.0
 * 
*/

@Entity
@Table(name = "quiz")
public class Quiz implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	private static final long serialVersionUID = 65628L;

	@Size(min = 2, max = 100, message = "The name must be between 2 and 100 messages.")
	@NotNull(message = "Please provide a name")
	private String name;

	@Size(max = 500, message = "The description can't be longer than 500 characters.")
	@NotNull(message = "Please, provide a description")
	private String description;

	/** Represents the Quiz questions.
	*/
	
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Question> questions;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	private Calendar createdDate;

	/** Gets the Quiz's name.
	 * @return A string representing the quiz name. 
	 *     
	*/
	
	public String getName() {
		return name;
	}

	/** Sets the Quiz name.
	 * @param name A String containing the quiz name
	*/
	public void setName(String name) {
		this.name = name;
	}

	/** Gets the Quiz's description.
	 * @return A string representing the quiz description. 
	 *     
	*/
	public String getDescription() {
		return description;
	}
	/** Sets the Quiz description.
	 * @param description A String containing the quiz description
	*/
	public void setDescription(String description) {
		this.description = description;
	}
	/** Gets the Quiz questions.
	 * @return A List representing the quiz questions. 
	 *     
	*/
	@JsonManagedReference
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * Sets the Quiz questions.
	 * 
	 * @param questions A List containing the quiz questions
	 */

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}
	/** Creates a quiz with the specified params.
	 * @param name, The name of the quiz.
	 * @param description, the description of the quiz.
	*/
	public Quiz(String name, String description) {
		this.name = name;
		this.description = description;

	}

	public Quiz() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
