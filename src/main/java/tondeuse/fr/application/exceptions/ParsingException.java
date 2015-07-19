package tondeuse.fr.application.exceptions;

/**
 * Exception levee quand le fichier en entree n'a pas la bonne forme
 * @author Mathieu
 *
 */
public class ParsingException extends Exception {
	public ParsingException(String message){
		super(message);
	}
}
