package tondeuse.fr.application.utils;

import java.util.List;

import tondeuse.fr.application.model.Tondeuse;

/**
 * Classe utilitaire permettant d'imprimer les positions des tondeuses (pour le moment en console)
 * @author Mathieu
 *
 */
public class PrintPositions {

	public static void printInConsole(List<Tondeuse> tondeuses) {
		
		for (Tondeuse tondeuse : tondeuses) {
			System.out.println(tondeuse.getPosition().getxPosition() + " " + tondeuse.getPosition().getyPosition() + " "
					+ tondeuse.getOrientation().toString().charAt(0));
		}
	}
}
