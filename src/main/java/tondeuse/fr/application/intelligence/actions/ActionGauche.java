package tondeuse.fr.application.intelligence.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tondeuse.fr.application.model.AbstractAction;
import tondeuse.fr.application.model.Position;
import tondeuse.fr.application.model.Tondeuse;
import tondeuse.fr.application.model.Tondeuse.Orientation;

public class ActionGauche extends AbstractAction {
	
	static final Logger LOGGER = LoggerFactory.getLogger(ActionGauche.class);
	
	public ActionGauche(Position coinSuperieurDroit) {
		super(coinSuperieurDroit);
	}

	@Override
	public void execute(Tondeuse tondeuse) {
		LOGGER.info("Action Gauche debutee");
		LOGGER.info("Position initiale ({},{})", tondeuse.getPosition()
				.getxPosition(), tondeuse.getPosition().getyPosition());
		LOGGER.info("Orientation initiale {}", tondeuse.getOrientation());
		
		switch (tondeuse.getOrientation()) {
		case EAST:
			tondeuse.setOrientation(Orientation.NORTH);
			break;
		case WEST:
			tondeuse.setOrientation(Orientation.SOUTH);
			break;
		case NORTH:
			tondeuse.setOrientation(Orientation.WEST);
			break;
		case SOUTH:
			tondeuse.setOrientation(Orientation.EAST);
			break;
		}
		
		LOGGER.info("Position finale ({},{})", tondeuse.getPosition()
				.getxPosition(), tondeuse.getPosition().getyPosition());
		LOGGER.info("Orientation finale {}", tondeuse.getOrientation());
		LOGGER.info("Action Avance finie");
	}

}
