package tondeuse.fr.application.model;


/**
 * Classe d'abstraction pour les differentes actions possibles
 * @author Mathieu
 *
 */
public abstract class AbstractAction {

	protected Position coinSuperieurDroit;
    
	
	public AbstractAction(final Position coinSuperieurDroit) {
		this.coinSuperieurDroit = coinSuperieurDroit;
	}


	public abstract void execute(Tondeuse tondeuse);
}
