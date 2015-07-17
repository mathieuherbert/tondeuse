package tondeuse.fr.application.exceptions;

/**
 * 
 * Exception levée quand une position n'est pas conforme
 *
 */
public class IllegalPositionException extends Exception {

	public IllegalPositionException(String message){
		super(message);
	}
}
