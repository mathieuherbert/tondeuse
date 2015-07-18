package tondeuse.fr.application.intelligence;

import org.junit.Test;

import tondeuse.fr.application.exceptions.IllegalPositionException;
import tondeuse.fr.application.intelligence.actions.ActionAvance;
import tondeuse.fr.application.intelligence.actions.ActionDroite;
import tondeuse.fr.application.intelligence.actions.ActionGauche;
import tondeuse.fr.application.model.AbstractAction;
import tondeuse.fr.application.model.Plateau;
import tondeuse.fr.application.model.Position;
import tondeuse.fr.application.model.Tondeuse;
import tondeuse.fr.application.model.Tondeuse.Orientation;

public class PassageTondeusesTest {

	@Test
	public void test() throws IllegalPositionException {
		
		
		Position coinSuperieur = new Position(5, 5);
		AbstractAction actionGauche = new ActionGauche(coinSuperieur);
		AbstractAction actionDroite = new ActionDroite(coinSuperieur);
		AbstractAction actionAvance = new ActionAvance(coinSuperieur);
		Plateau plateau = new Plateau(coinSuperieur);
		
		Tondeuse tondeuse1 = new Tondeuse(Orientation.NORTH, new Position(1,2));
		tondeuse1.addAction(actionGauche);
		tondeuse1.addAction(actionAvance);
		tondeuse1.addAction(actionGauche);
		tondeuse1.addAction(actionAvance);
		tondeuse1.addAction(actionGauche);
		tondeuse1.addAction(actionAvance);
		tondeuse1.addAction(actionGauche);
		tondeuse1.addAction(actionAvance);
		tondeuse1.addAction(actionAvance);
		plateau.addTondeuse(tondeuse1);
		
		Tondeuse tondeuse2 = new Tondeuse(Orientation.EAST, new Position(3,3));
		tondeuse2.addAction(actionAvance);
		tondeuse2.addAction(actionAvance);
		tondeuse2.addAction(actionDroite);
		tondeuse2.addAction(actionAvance);
		tondeuse2.addAction(actionAvance);
		tondeuse2.addAction(actionDroite);
		tondeuse2.addAction(actionAvance);
		tondeuse2.addAction(actionDroite);
		tondeuse2.addAction(actionDroite);
		tondeuse2.addAction(actionAvance);
		plateau.addTondeuse(tondeuse2);
		
		PassageTondeuses passageTondeuses = new PassageTondeuses(plateau);
		passageTondeuses.passerTondeuses();
	}

}
