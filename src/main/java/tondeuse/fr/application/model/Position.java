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
}
