package tondeuse.fr.application.utils;

import java.util.List;

import tondeuse.fr.application.model.Tondeuse;

public class PrintPositions {

	public static void printInConsole(List<Tondeuse> tondeuses) {
		
		for (Tondeuse tondeuse : tondeuses) {
			System.out.println(tondeuse.getPosition().getxPosition() + " " + tondeuse.getPosition().getyPosition() + " "
					+ tondeuse.getOrientation().toString().charAt(0));
		}
	}
}
