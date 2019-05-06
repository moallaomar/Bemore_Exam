package fr.bemore.Exceptions;

public class QuizNotFoundException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuizNotFoundException(Integer id) {
        super("Le quiz est introuvable" + id);
    }
}
