package tondeuse.fr.application.fichiers;

import java.util.ArrayList;
import java.util.List;

import tondeuse.fr.application.exceptions.IllegalPositionException;
import tondeuse.fr.application.exceptions.ParsingException;
import tondeuse.fr.application.intelligence.actions.ActionAvance;
import tondeuse.fr.application.intelligence.actions.ActionDroite;
import tondeuse.fr.application.intelligence.actions.ActionGauche;
import tondeuse.fr.application.model.AbstractAction;
import tondeuse.fr.application.model.Plateau;
import tondeuse.fr.application.model.Position;
import tondeuse.fr.application.model.Tondeuse;
import tondeuse.fr.application.model.Tondeuse.Orientation;

/**
 * Gestion du chargement des differents elements (Coordonees, Orientation, Action)
 * 
 * @author Mathieu
 *
 */
public class LoadElements {
   /**
    * Charge un objet Postion à partir d'un tableau de String
    * @param ligneSplited exemple 1,2
    * @return la position
    * @throws IllegalPositionException
    * @throws ParsingException
    */
	public static Position loadCoordonnees(String[] ligneSplited)
			throws IllegalPositionException, ParsingException {
		if (ligneSplited.length != 2) {
			throw new ParsingException(
					"Les coordonnees doivent etre de la forme x y (ligne : "
							+ ligneSplited + ")");
		}
		int xPosition;
		int yPosition;
		try {
			xPosition = Integer.parseInt(ligneSplited[0]);
			yPosition = Integer.parseInt(ligneSplited[1]);
		} catch (NumberFormatException e) {
			throw new ParsingException(
					"les coordonees doivent etre des entiers");
		}
		return new Position(xPosition, yPosition);
	}
	/**
	 * Charge l'orientation à partir d'un String
	 * @param orientationString au choix : E, W, S, N
	 * @return l'orientation
	 * @throws IllegalPositionException
	 * @throws ParsingException
	 */
	public static Orientation loadOrientation(String orientationString)
			throws IllegalPositionException, ParsingException {
		Orientation orientation;
		switch(orientationString){
			case "E" :
			 orientation = Orientation.EAST;
			 break;
			case "W" :
				 orientation = Orientation.WEST;
				 break;
			case "S" :
				 orientation = Orientation.SOUTH;
				 break;
			case "N" :
				 orientation = Orientation.NORTH;
				 break;
		    default:
		    	throw new ParsingException("Orientation non conforme (valeures valdies : N,E,W,S)");
				 
		}
		return orientation;
		
	}
	/**
	 * Charge les actions à partir d'une ligne
	 * @param ligne exemple GADGGG
	 * @param coinSuperieur le coin superieur du plateau
	 * @return la serie d'action
	 * @throws ParsingException
	 */
	public static List<AbstractAction> loadActions(String ligne,Position coinSuperieur) throws ParsingException{
		List<AbstractAction> actions = new ArrayList<AbstractAction>();
		AbstractAction actionGauche = new ActionGauche(coinSuperieur);
		AbstractAction actionAvance = new ActionAvance(coinSuperieur);
		AbstractAction actionDroite = new ActionDroite(coinSuperieur);
		ligne = ligne.trim();
		int nbActionsPrevues = ligne.length();
		for(int i = 0; i < nbActionsPrevues; i++ ){
			char actionChar = ligne.charAt(i);
			switch (actionChar) {
			case 'G':
				actions.add(actionGauche);
				break;
			case 'D':
				actions.add(actionDroite);
				break;
			case 'A':
				actions.add(actionAvance);
				break;
			default:
				throw new ParsingException("Action non conforme (valeures valides : ADG)");
			}
		}
		return actions;
	}
	/**
	 * Charge pour une tondeuse ses corrdonées et son orientation à partir d'une ligne
	 * @param ligne exemple 2 3 S
	 * @return un objet Tondeuse
	 * @throws IllegalPositionException
	 * @throws ParsingException
	 */
	public static Tondeuse loadTondeuseCoordonneesEtOrientation(String ligne)
			throws IllegalPositionException, ParsingException {
		String[] ligneSplited = ligne.split(" ");
		if (ligneSplited.length != 3) {
			throw new ParsingException(
					"Les coordonnees et l'orientation doivent etre de la forme x y o(ligne : "
							+ ligneSplited + ")");
		}
		Position position = loadCoordonnees(new String[]{ligneSplited[0], ligneSplited[1]});
		Orientation orientation = loadOrientation(ligneSplited[2]);
		return new Tondeuse(orientation,position);
	}
}
