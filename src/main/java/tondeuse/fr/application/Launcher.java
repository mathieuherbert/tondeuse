package tondeuse.fr.application;

import tondeuse.fr.application.exceptions.ParsingException;
import tondeuse.fr.application.fichiers.GestionFichier;
import tondeuse.fr.application.intelligence.PassageTondeuses;
import tondeuse.fr.application.model.Plateau;

/**
 * Classe de lancement de l'application
 * @author Mathieu
 *
 */
public class Launcher {

	public static void main(String[] args) throws ParsingException {
		if(args.length != 1){
			throw new IllegalArgumentException("Le chemin vers le fichier doit etre donne en entree");
		}
		
		Plateau plateau = GestionFichier.chargerFichier(args[0]);
		PassageTondeuses passageTondeuses = new PassageTondeuses(plateau);
		passageTondeuses.passerTondeuses();
		
	}

}
