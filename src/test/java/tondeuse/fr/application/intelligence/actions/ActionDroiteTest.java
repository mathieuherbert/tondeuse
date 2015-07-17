package tondeuse.fr.application.intelligence.actions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import tondeuse.fr.application.exceptions.IllegalPositionException;
import tondeuse.fr.application.model.Position;
import tondeuse.fr.application.model.Tondeuse;
import tondeuse.fr.application.model.Tondeuse.Orientation;

public class ActionDroiteTest {
	private Position coinSuperieur;

	@Before
	public void setUp() throws IllegalPositionException {
		this.coinSuperieur = new Position(3, 3);
	}

	@Test
	public void testExecuteAPartirDuNord() throws IllegalPositionException {

		Position positionInitialeTondeuse = new Position(1, 2);
		Tondeuse tondeuse = new Tondeuse(Orientation.NORTH,
				positionInitialeTondeuse);

		ActionDroite actionDroite = new ActionDroite(coinSuperieur);
		actionDroite.execute(tondeuse);
		assertEquals(tondeuse.getPosition(), new Position(1, 2));
		assertSame(tondeuse.getOrientation(), Orientation.EAST);
	}
	
	@Test
	public void testExecuteAPartirDeEst() throws IllegalPositionException {

		Position positionInitialeTondeuse = new Position(1, 2);
		Tondeuse tondeuse = new Tondeuse(Orientation.EAST,
				positionInitialeTondeuse);

		ActionDroite actionDroite = new ActionDroite(coinSuperieur);
		actionDroite.execute(tondeuse);
		assertEquals(tondeuse.getPosition(), new Position(1, 2));
		assertSame(tondeuse.getOrientation(), Orientation.SOUTH);
	}
	
	@Test
	public void testExecuteAPartirDuSud() throws IllegalPositionException {

		Position positionInitialeTondeuse = new Position(1, 2);
		Tondeuse tondeuse = new Tondeuse(Orientation.SOUTH,
				positionInitialeTondeuse);

		ActionDroite actionDroite = new ActionDroite(coinSuperieur);
		actionDroite.execute(tondeuse);
		assertEquals(tondeuse.getPosition(), new Position(1, 2));
		assertSame(tondeuse.getOrientation(), Orientation.WEST);
	}
	
	@Test
	public void testExecuteAPartirDeOuest() throws IllegalPositionException {

		Position positionInitialeTondeuse = new Position(1, 2);
		Tondeuse tondeuse = new Tondeuse(Orientation.WEST,
				positionInitialeTondeuse);

		ActionDroite actionDroite = new ActionDroite(coinSuperieur);
		actionDroite.execute(tondeuse);
		assertEquals(tondeuse.getPosition(), new Position(1, 2));
		assertSame(tondeuse.getOrientation(), Orientation.NORTH);
	}

}
