package tondeuse.fr.application.model;

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
	
	
	public Tondeuse(Orientation orientation, Position position) {
		this.orientation = orientation;
		this.position = position;
	}

	/**
	 * Position de la tondeuse
	 */
	private Position position;
	
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
	

}
