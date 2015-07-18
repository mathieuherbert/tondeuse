package tondeuse.fr.application.utils;

import java.util.List;

import tondeuse.fr.application.model.Tondeuse;

public class PrintPositions {

	public static void printInConsole(List<Tondeuse> tondeuses){
		System.out.println("---------Position des tondeuses--------");
		for(Tondeuse tondeuse : tondeuses){
			System.out.println(" - position tondeuse : "+tondeuse.getPosition().getxPosition() +" "+tondeuse.getPosition().getyPosition());
			System.out.println("   orientation tondeuse : "+tondeuse.getOrientation());
		}
	}
}
