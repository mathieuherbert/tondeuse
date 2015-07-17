package tondeuse.fr.application.model;

import java.util.ArrayList;

/**
 * Représente le Plateau sur lequel évoluent les tondeuses
 * @author Mathieu
 *
 */
public class Plateau {
	/**
	 * Coin Supérieur Droite de la Pelouses 
	 */
	private Position coinHautDroite;
	
	private ArrayList<Tondeuse> tondeuses;
	public Plateau(Position coinHautDroite) {
		this.coinHautDroite = coinHautDroite;
		this.tondeuses = new ArrayList<Tondeuse>();
	}

	public Position getCoinHautDroite() {
		return coinHautDroite;
	}
	/**
	 * Ajoute une tondeuse dans la liste des tondeuses
	 * @param tondeuse
	 */
	public void addTondeuse(Tondeuse tondeuse){
		this.tondeuses.add(tondeuse);
	}
}
