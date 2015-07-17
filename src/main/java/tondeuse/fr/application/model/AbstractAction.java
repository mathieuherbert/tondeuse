package tondeuse.fr.application.model;


public abstract class AbstractAction {
	/**
	 * 
	 * Les différentes actions possibles :
	 * - GAUCHE : tourne de 90 degrés sur la gauche
	 * - DROITE : tourne de 90 degrés sur la droite
	 * - AVANCE : avance quand cela est possible
	 */
	public enum Action {
		GAUCHE, DROITE, AVANCE
	}
	
	protected Position coinSuperieurDroit;
    
	
	public AbstractAction(Position coinSuperieurDroit) {
		this.coinSuperieurDroit = coinSuperieurDroit;
	}


	public abstract void execute(Tondeuse tondeuse);
}