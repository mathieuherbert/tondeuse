package tondeuse.fr.application.fichiers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import tondeuse.fr.application.exceptions.IllegalPositionException;
import tondeuse.fr.application.exceptions.ParsingException;
import tondeuse.fr.application.model.Plateau;
import tondeuse.fr.application.model.Position;
import tondeuse.fr.application.model.Tondeuse.Orientation;

public class GestionFichierTest {

	@Test(expected = ParsingException.class) 
	public void testFichierNonExistant() throws ParsingException {
		String path = "src/test/resources/fichiersTest/notexist";
		GestionFichier.chargerFichier(path);
	}
	
	@Test
	public void testSansTondeuse() throws ParsingException, IllegalPositionException {
		String path = "src/test/resources/fichiersTest/sansTondeuse";
		Plateau plateau = GestionFichier.chargerFichier(path);
		assertEquals(new Position(5, 5), plateau.getCoinHautDroite());
		assertSame(0,plateau.getTondeuses().size());
	}
	
	@Test
	public void testUneTondeuse() throws ParsingException, IllegalPositionException{
		String path = "src/test/resources/fichiersTest/uneTondeuse";
		Plateau plateau = GestionFichier.chargerFichier(path);
		assertEquals(new Position(5, 5), plateau.getCoinHautDroite());
		assertSame(1,plateau.getTondeuses().size());
		assertEquals(new Position(1,2), plateau.getTondeuses().get(0).getPosition());
		assertSame(Orientation.NORTH, plateau.getTondeuses().get(0).getOrientation());
		assertSame(9, plateau.getTondeuses().get(0).getSequenceActions().size());
	}

	@Test
	public void testDeuxTondeuses() throws ParsingException, IllegalPositionException {
		String path = "src/test/resources/fichiersTest/deuxTondeuses";
		Plateau plateau = GestionFichier.chargerFichier(path);
		assertEquals(new Position(5, 5), plateau.getCoinHautDroite());
		assertSame(2,plateau.getTondeuses().size());
		assertEquals(new Position(1,2), plateau.getTondeuses().get(0).getPosition());
		assertSame(Orientation.NORTH, plateau.getTondeuses().get(0).getOrientation());
		assertSame(9, plateau.getTondeuses().get(0).getSequenceActions().size());
		
		assertEquals(new Position(3,3), plateau.getTondeuses().get(1).getPosition());
		assertSame(Orientation.EAST, plateau.getTondeuses().get(1).getOrientation());
		assertSame(10, plateau.getTondeuses().get(1).getSequenceActions().size());
	}
	
	@Test(expected = ParsingException.class)
	public void testCoordoneesDroiteInfZero() throws ParsingException  {
		String path = "src/test/resources/fichiersTest/coordoneeDroiteInfZero";
		GestionFichier.chargerFichier(path);
	}
	
	@Test(expected = ParsingException.class)
	public void testOrientationNonExistante() throws ParsingException {
		String path = "src/test/resources/fichiersTest/orientationNonExistante";
		GestionFichier.chargerFichier(path);
	}
	
	@Test
	public void testActionNonExistante() throws ParsingException, IllegalPositionException {
		String path = "src/test/resources/fichiersTest/actionNonExistante";
		Plateau plateau =GestionFichier.chargerFichier(path);
		
		assertEquals(new Position(5, 5), plateau.getCoinHautDroite());
		assertSame(2,plateau.getTondeuses().size());
		assertEquals(new Position(1,2), plateau.getTondeuses().get(0).getPosition());
		assertSame(Orientation.NORTH, plateau.getTondeuses().get(0).getOrientation());
		assertSame(0, plateau.getTondeuses().get(0).getSequenceActions().size());
		
		assertEquals(new Position(3,3), plateau.getTondeuses().get(1).getPosition());
		assertSame(Orientation.EAST, plateau.getTondeuses().get(1).getOrientation());
		assertSame(10, plateau.getTondeuses().get(1).getSequenceActions().size());
	}
	
	@Test(expected = ParsingException.class)
	public void testLigneSupplementaire() throws ParsingException {
		String path = "ligneSupplementaire";
		GestionFichier.chargerFichier(path);
	}
	

}
