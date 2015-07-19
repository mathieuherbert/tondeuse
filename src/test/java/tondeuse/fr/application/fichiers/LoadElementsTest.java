package tondeuse.fr.application.fichiers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;

import tondeuse.fr.application.exceptions.IllegalPositionException;
import tondeuse.fr.application.exceptions.ParsingException;
import tondeuse.fr.application.intelligence.actions.ActionAvance;
import tondeuse.fr.application.intelligence.actions.ActionDroite;
import tondeuse.fr.application.intelligence.actions.ActionGauche;
import tondeuse.fr.application.model.AbstractAction;
import tondeuse.fr.application.model.Position;
import tondeuse.fr.application.model.Tondeuse;
import tondeuse.fr.application.model.Tondeuse.Orientation;

public class LoadElementsTest {

	@Test
	public void testLoadCoordonneesCasNominal() throws IllegalPositionException, ParsingException {
		String[] coordonneesTab = {"2", "2"};
		
		Position position = LoadElements.loadCoordonnees(coordonneesTab);
		
		assertEquals(position, new Position(2, 2));
	}
	
	@Test(expected = IllegalPositionException.class)
	public void testLoadCoordonneesCasInf0() throws IllegalPositionException, ParsingException {
		String[] coordonneesTab = {"-2", "2"};
		
		Position position = LoadElements.loadCoordonnees(coordonneesTab);
		
	}

	@Test(expected = ParsingException.class)
	public void testLoadCoordonneesCasManqueUneCordonnee() throws IllegalPositionException, ParsingException {
		String[] coordonneesTab = { "2"};
		
		Position position = LoadElements.loadCoordonnees(coordonneesTab);
		
	}
	
	@Test(expected = ParsingException.class)
	public void testLoadCoordonneesCasTroisCordonnees() throws IllegalPositionException, ParsingException {
		String[] coordonneesTab = { "2" , "2", "2"};
		
		Position position = LoadElements.loadCoordonnees(coordonneesTab);
		
	}
	
	@Test(expected = ParsingException.class)
	public void testLoadCoordonneesCasNonEntier() throws IllegalPositionException, ParsingException {
		String[] coordonneesTab = { "2" , "A"};
		Position position = LoadElements.loadCoordonnees(coordonneesTab);
	}
	
	@Test
	public void testLoadOrientationNominals() throws IllegalPositionException, ParsingException {
		String orientationString = "E";
		Orientation orientation = LoadElements.loadOrientation(orientationString);
		assertSame(orientation, Orientation.EAST);
		
		orientationString = "W";
		orientation = LoadElements.loadOrientation(orientationString);
		assertSame(orientation, Orientation.WEST);
		
		orientationString = "N";
		orientation = LoadElements.loadOrientation(orientationString);
		assertSame(orientation, Orientation.NORTH);
		
		orientationString = "S";
		orientation = LoadElements.loadOrientation(orientationString);
		assertSame(orientation, Orientation.SOUTH);
		
	}
	
	@Test(expected = ParsingException.class)
	public void testLoadOrientationLettreNomConforme() throws IllegalPositionException, ParsingException {
		String orientationString = "A";
		LoadElements.loadOrientation(orientationString);
	}
	
	@Test(expected = ParsingException.class)
	public void testLoadOrientationPlusieursLettre() throws IllegalPositionException, ParsingException {
		String orientationString = "EW";
		LoadElements.loadOrientation(orientationString);
	}
	
	@Test(expected = ParsingException.class)
	public void testLoadOrientationVide() throws IllegalPositionException, ParsingException {
		String orientationString = "";
		LoadElements.loadOrientation(orientationString);
	}
	
	@Test
	public void testLoadActionsNominalsUneLettre() throws IllegalPositionException, ParsingException {
		Position coinSuperieur = new Position(2, 2);
		String actionString = "A";
		List<AbstractAction> action = LoadElements.loadActions(actionString, coinSuperieur);
		assertEquals(1, action.size());
		assertSame(action.get(0).getClass(), ActionAvance.class );
	
		
		actionString = "G";
		action = LoadElements.loadActions(actionString, coinSuperieur);
		assertEquals(1, action.size());
		assertSame(action.get(0).getClass(), ActionGauche.class );
		
		actionString = "D";
		action = LoadElements.loadActions(actionString, coinSuperieur);
		assertEquals(1, action.size());
		assertSame(action.get(0).getClass(), ActionDroite.class );
		
		
	}
	
	@Test(expected = ParsingException.class)
	public void testLoadActionsLettreNomConforme() throws IllegalPositionException, ParsingException {
		Position coinSuperieur = new Position(2, 2);
		String actionString = "V";
		List<AbstractAction> action = LoadElements.loadActions(actionString, coinSuperieur);
		assertEquals(1, action.size());
		
	}
	
	@Test
	public void testLoadActionsPlusieursLettre() throws IllegalPositionException, ParsingException {
		Position coinSuperieur = new Position(2, 2);
		String actionString = "AGD";
		List<AbstractAction> action = LoadElements.loadActions(actionString, coinSuperieur);
		assertEquals(3, action.size());
		assertSame(action.get(0).getClass(), ActionAvance.class );
		assertSame(action.get(1).getClass(), ActionGauche.class );
		assertSame(action.get(2).getClass(), ActionDroite.class );
	}
	
	@Test
	public void testLoadActionsVide() throws IllegalPositionException, ParsingException {
		Position coinSuperieur = new Position(2, 2);
		String actionString = "";
		List<AbstractAction> action = LoadElements.loadActions(actionString, coinSuperieur);
		assertEquals(0, action.size());
		
	}


	@Test
	public void testLoadTondeuseCoordonneesEtOrientationNominal() throws IllegalPositionException, ParsingException {
		String ligne = "1 2 N";
		
		Tondeuse tondeuse = LoadElements.loadTondeuseCoordonneesEtOrientation(ligne);
		
		assertEquals(tondeuse.getOrientation(), Orientation.NORTH);
		assertEquals(tondeuse.getPosition(), new Position(1, 2));
	}
	
	@Test(expected= ParsingException.class)
	public void testLoadTondeuseCoordonneesEtOrientationSansOrientation() throws IllegalPositionException, ParsingException {
		String ligne = "1 2";
		
		Tondeuse tondeuse = LoadElements.loadTondeuseCoordonneesEtOrientation(ligne);
		
	}
	@Test(expected= ParsingException.class)
	public void testLoadTondeuseCoordonneesEtOrientationManqueUneCoordonnee() throws IllegalPositionException, ParsingException {
		String ligne = "1 N";
		
		Tondeuse tondeuse = LoadElements.loadTondeuseCoordonneesEtOrientation(ligne);
		
	}

}
