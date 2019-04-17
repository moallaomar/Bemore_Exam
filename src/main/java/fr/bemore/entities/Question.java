package fr.bemore.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

@Entity
@Table(name= "question")
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true ,nullable = false)
	private Integer id;
	@Lob
	@Column(name="content",nullable = false, length= 1000)
	private String content;
	@OneToMany(fetch = FetchType.LAZY , mappedBy="question", cascade = CascadeType.ALL)
	private Set<Answer> answers = new HashSet<Answer>(0);
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="quiz_id", nullable = false)
	private Quiz quiz;

	Question(String content){
		this.content = content;
	}
	
	
	Question()
	{
		
	}


	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
}
