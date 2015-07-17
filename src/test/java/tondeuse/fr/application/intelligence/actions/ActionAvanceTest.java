package tondeuse.fr.application.intelligence.actions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import tondeuse.fr.application.exceptions.IllegalPositionException;
import tondeuse.fr.application.model.Position;
import tondeuse.fr.application.model.Tondeuse;
import tondeuse.fr.application.model.Tondeuse.Orientation;

public class ActionAvanceTest {
	private Position coinSuperieur;
	
	 @Before
	 public void setUp() throws IllegalPositionException {
		 this.coinSuperieur = new Position(3, 3);
	}
	
	@Test
	public void testExecuteCasNominal() throws IllegalPositionException {
		
		Position positionInitialeTondeuse = new Position(1, 1);
		Tondeuse tondeuse = new Tondeuse(Orientation.NORTH, positionInitialeTondeuse);
		
		ActionAvance actionAvance = new ActionAvance(coinSuperieur);
		actionAvance.execute(tondeuse);
		assertEquals(tondeuse.getPosition(), new Position(1, 2));
		
	}
	
	@Test
	public void testExecuteCasProcheBordY() throws IllegalPositionException {
				
		Position positionInitialeTondeuse = new Position(1, 2);
		Tondeuse tondeuse = new Tondeuse(Orientation.NORTH, positionInitialeTondeuse);
		
		ActionAvance actionAvance = new ActionAvance(coinSuperieur);
		actionAvance.execute(tondeuse);
		assertEquals(tondeuse.getPosition(), new Position(1, 3));
	}
	
	@Test
	public void testExecuteCasProcheBordX() throws IllegalPositionException {
		
		Position positionInitialeTondeuse = new Position(2, 1);
		Tondeuse tondeuse = new Tondeuse(Orientation.EAST, positionInitialeTondeuse);
		
		ActionAvance actionAvance = new ActionAvance(coinSuperieur);
		actionAvance.execute(tondeuse);
		assertEquals(tondeuse.getPosition(), new Position(3, 1));
	}
	
	@Test
	public void testExecuteCasDehorsX() throws IllegalPositionException {
		
		Position positionInitialeTondeuse = new Position(3, 1);
		Tondeuse tondeuse = new Tondeuse(Orientation.EAST, positionInitialeTondeuse);
		
		ActionAvance actionAvance = new ActionAvance(coinSuperieur);
		actionAvance.execute(tondeuse);
		assertEquals(tondeuse.getPosition(), new Position(3, 1));
	}
	
	@Test
	public void testExecuteCasDehorsY() throws IllegalPositionException {
		
		Position positionInitialeTondeuse = new Position(1, 3);
		Tondeuse tondeuse = new Tondeuse(Orientation.NORTH, positionInitialeTondeuse);
		
		ActionAvance actionAvance = new ActionAvance(coinSuperieur);
		actionAvance.execute(tondeuse);
		assertEquals(tondeuse.getPosition(), new Position(1, 3));
	}
	
	@Test
	public void testExecuteCasDehorsYDessous0() throws IllegalPositionException {
		
		Position positionInitialeTondeuse = new Position(1, 0);
		Tondeuse tondeuse = new Tondeuse(Orientation.SOUTH, positionInitialeTondeuse);
		
		ActionAvance actionAvance = new ActionAvance(coinSuperieur);
		actionAvance.execute(tondeuse);
		assertEquals(tondeuse.getPosition(), new Position(1, 0));
	}
	
	@Test
	public void testExecuteCasDehorsXDessous0() throws IllegalPositionException {
		
		Position positionInitialeTondeuse = new Position(0, 1);
		Tondeuse tondeuse = new Tondeuse(Orientation.WEST, positionInitialeTondeuse);
		
		ActionAvance actionAvance = new ActionAvance(coinSuperieur);
		actionAvance.execute(tondeuse);
		assertEquals(tondeuse.getPosition(), new Position(0, 1));
	}
}
