package tondeuse.fr.application.model;

public class Tondeuse {
	/**
	 * 
	 * les différentes orientations possibles
	 */
	public enum Orientation {
		NORTH, EST, WEST, SOUTH
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
	
	

}
