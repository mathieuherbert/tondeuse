package tondeuse.fr.application.intelligence.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tondeuse.fr.application.exceptions.IllegalPositionException;
import tondeuse.fr.application.model.Position;
import tondeuse.fr.application.model.Tondeuse;

/**
 * Permet de faire avancer une tondeuse
 * @author Mathieu
 *
 */
public class ActionAvance extends AbstractAction {
	static final Logger LOGGER = LoggerFactory.getLogger(ActionAvance.class);

	public ActionAvance(Position coinSuperieurDroit) {
		super(coinSuperieurDroit);
		LOGGER.debug("Action Avance detectee");
	}

	@Override
	public void execute(Tondeuse tondeuse) {
		LOGGER.info("Action Avance debutee");
		LOGGER.info("Position initiale ({},{})", tondeuse.getPosition()
				.getxPosition(), tondeuse.getPosition().getyPosition());
		LOGGER.info("Orientation initiale {}", tondeuse.getOrientation());

		switch (tondeuse.getOrientation()) {
		case EAST:
			avanceEast(tondeuse.getPosition());
			break;
		case WEST:
			avanceWest(tondeuse.getPosition());
			break;
		case NORTH:
			avanceNorth(tondeuse.getPosition());
			break;
		case SOUTH:
			avanceSouth(tondeuse.getPosition());
			break;
		}

		LOGGER.info("Position finale ({},{})", tondeuse.getPosition()
				.getxPosition(), tondeuse.getPosition().getyPosition());
		LOGGER.info("Orientation finale {}", tondeuse.getOrientation());
		LOGGER.info("Action Avance finie");
	}

	private void avanceEast(Position position) {
		int xInitiale = position.getxPosition();
		if (xInitiale + 1 <= coinSuperieurDroit.getxPosition()) {
			LOGGER.debug("Autorisation d avancer");
			try {
				position.setxPosition(xInitiale + 1);
			} catch (IllegalPositionException e) {
				LOGGER.error("Erreur non conforme");
			}
		}
	}

	private void avanceWest(Position position) {
		int xInitiale = position.getxPosition();
		try {
			position.setxPosition(xInitiale - 1);
			LOGGER.debug("Autorisation d avancer");
		} catch (IllegalPositionException e) {
			LOGGER.debug("Non autorise a avancer");
		}

	}

	private void avanceSouth(Position position) {
		int yInitiale = position.getyPosition();
		try {
			position.setyPosition(yInitiale - 1);
			LOGGER.debug("Autorisation d avancer");
		} catch (IllegalPositionException e) {
			LOGGER.debug("Non autorise a avancer");
		}

	}

	private void avanceNorth(Position position) {
		int yInitiale = position.getyPosition();
		if (yInitiale + 1 <= coinSuperieurDroit.getyPosition()) {
			LOGGER.debug("Autorisation d avancer");
			try {
				position.setyPosition(yInitiale + 1);
			} catch (IllegalPositionException e) {
				LOGGER.error("Erreur non conforme");
			}
		}
	}

}
