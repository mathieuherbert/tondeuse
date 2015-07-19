package tondeuse.fr.application;

import tondeuse.fr.application.exceptions.ParsingException;
import tondeuse.fr.application.fichiers.GestionFichier;
import tondeuse.fr.application.intelligence.PassageTondeuses;
import tondeuse.fr.application.model.Plateau;
import tondeuse.fr.application.utils.PrintPositions;

/**
 * Classe de lancement de l'application
 * @author Mathieu
 *
 */
public class Launcher {

	public static void main(String[] args) {
		if(args.length != 1){
			System.err.println("Le chemin vers le fichier doit etre donne en entree");
			System.exit(-1);
		}
		try{
		//passage des tondeuses
		Plateau plateau = GestionFichier.chargerFichier(args[0]);
		PassageTondeuses passageTondeuses = new PassageTondeuses(plateau);
		passageTondeuses.passerTondeuses();
		//impression des resultats
		PrintPositions.printInConsole(plateau.getTondeuses());
		}catch(ParsingException e){
			System.err.println("erreur detectee"+e.getMessage());
			System.exit(-1);
		}
	}

}
