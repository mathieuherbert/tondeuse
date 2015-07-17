package tondeuse.fr.application.model;

import java.util.ArrayList;

import tondeuse.fr.application.intelligence.actions.AbstractAction;

public class Tondeuse {
	/**
	 * 
	 * les différentes orientations possibles
	 */
	public enum Orientation {
		NORTH, EAST, WEST, SOUTH
	}
    /**
     * l'orientation de la tondeuse
     */
	private Orientation orientation;
	
	/**
	 * Position de la tondeuse
	 */
	private Position position;
	
	/**
	 * Liste des actions que la tondeuse doit executer
	 */
	private ArrayList<AbstractAction> sequenceActions; 
	public Tondeuse(Orientation orientation, Position position) {
		this.orientation = orientation;
		this.position = position;
		this.sequenceActions = new ArrayList<AbstractAction>();
	}


	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	/**
	 * Ajoute une action a la liste des actions
	 * @param action
	 */
	public void addAction(AbstractAction action){
		this.sequenceActions.add(action);
	}

}
