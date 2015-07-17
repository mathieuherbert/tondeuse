package tondeuse.fr.application.model;

import tondeuse.fr.application.exceptions.IllegalPositionException;

/**
 * Représente une position sur un Plateau
 * 
 * @author Mathieu
 *
 */
public class Position {
	
	/**
	 * Représente la position X (> 0)
	 */
	private int xPosition;

	/**
	 * Représente la position Y (> 0)
	 */
	private int yPosition;
   /**
    * 
    * @param xPosition doit etre > 0
    * @param yPosition doit etre > 0
    * @throws IllegalPositionException
    */
	public Position(int xPosition, int yPosition) throws IllegalPositionException {
		if (xPosition < 0 || yPosition < 0)
			throw new IllegalPositionException("Position (" + xPosition + ","
					+ yPosition + ") est en dehors du plateau");
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public int getxPosition() {
		return xPosition;
	}
	/**
	 * 
	 * @param xPosition doit etre > 0
	 * @throws IllegalPositionException
	 */
	public void setxPosition(int xPosition) throws IllegalPositionException {
		if (xPosition < 0 || yPosition < 0)
			throw new IllegalPositionException("xPosition (" + xPosition + ") doit etre superieur a 0");
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}
    /**
     * 
     * @param yPosition doit etre > 0
     * @throws IllegalPositionException
     */
	public void setyPosition(int yPosition) throws IllegalPositionException {
		if (xPosition < 0 || yPosition < 0)
			throw new IllegalPositionException("xPosition (" + yPosition + ") doit etre superieur a 0");
		this.yPosition = yPosition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xPosition;
		result = prime * result + yPosition;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (xPosition != other.xPosition)
			return false;
		if (yPosition != other.yPosition)
			return false;
		return true;
	}
	
	
}
