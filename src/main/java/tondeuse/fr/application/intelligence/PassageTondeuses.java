package tondeuse.fr.application.intelligence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tondeuse.fr.application.intelligence.actions.ActionAvance;
import tondeuse.fr.application.model.AbstractAction;
import tondeuse.fr.application.model.Plateau;
import tondeuse.fr.application.model.Tondeuse;
import tondeuse.fr.application.utils.PrintPositions;

public class PassageTondeuses {
	private Plateau plateau;

	static final Logger LOGGER = LoggerFactory
			.getLogger(PassageTondeuses.class);

	public PassageTondeuses(Plateau plateau) {
		super();
		this.plateau = plateau;
	}

	public void passerTondeuses() {

		for (Tondeuse tondeuse : plateau.getTondeuses()) {
			LOGGER.info("-------nouvelle tondeuse ----------");
			for (AbstractAction action : tondeuse.getSequenceActions()) {
				LOGGER.info("---nouvelle action ---");
				action.execute(tondeuse);
			}
		}
		LOGGER.info("Toutes les tondeuses sont passées");
		PrintPositions.printInConsole(plateau.getTondeuses());
		

	}
	
}	
