package fr.bemore.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
/**
 * This class represents an answer.
 * 
 * @author Omar Moalla
 * 
 * @version 1.0
 * 
 */
@Entity
@Table(name = "answer")
public class Answer implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 148L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;
    /**
	 * Each Answer has a question_id.
	 */
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;


    @Lob
    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "correct", nullable = false)
    private boolean correct;
	/**
	 * Creates an answer without params.
	 */
    public Answer() {

    }
	/** Creates an answer with the specified params.
	 * @param content, this param represents  content of the question.
	 * @param correct,this param is a flag to check if the question is correct or not.
	*/
    public Answer(String content, boolean correct) {
        this.content = content;
        this.correct = correct;
    }
    /** Gets the Answer's  id.
	 * @return An Integer representing the answer's id. 
	 *     
	*/

    public Integer getId() {
        return id;
    }
	/** Sets the Answer's id.
	 * @param id An Integer containing the answer's id
	*/
    public void setId(Integer id) {
        this.id = id;
    }
    /** Gets the Question associated to the answer.
	 * @return A Question representing the question. 
	 *     
	*/
    public Question getQuestion() {
        return question;
    }
	/** Sets the Answer's question.
	 * @param question A Question containing the answer's Question
	*/
    public void setQuestion(Question question) {
        this.question = question;
    }
    /** Gets the Answer's content.
	 * @return A String representing the answer's content. 
	 *     
	*/
    public String getContent() {
        return content;
    }
	/** Sets the Answer's  Content.
	 * @param content A String containing the answer's content 
	*/
    public void setContent(String content) {
        this.content = content;
    }
    /** Gets the Answer's flag.
  	 * @return A boolean flag representing the correct answer. 
  	 *     
  	*/
    public boolean isCorrect() {
        return correct;
    }
	/** Sets the a flag to the correct answer.
	 * @param correct A boolean flag containing the correct answer. 
	*/
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }


}
