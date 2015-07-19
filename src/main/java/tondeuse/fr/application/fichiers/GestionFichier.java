package tondeuse.fr.application.fichiers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tondeuse.fr.application.exceptions.IllegalPositionException;
import tondeuse.fr.application.exceptions.ParsingException;
import tondeuse.fr.application.intelligence.PassageTondeuses;
import tondeuse.fr.application.model.Plateau;
import tondeuse.fr.application.model.Position;
import tondeuse.fr.application.model.Tondeuse;

/**
 * 
 * Classe permettant de transferer en objet memoire un fichier
 *
 */
public class GestionFichier {
	
	static final Logger LOGGER = LoggerFactory.getLogger(GestionFichier.class);
	
	private String path;
	/**
	 * 
	 * @param path le chemin du fichier
	 */
	private GestionFichier(String path) {
		this.path = path;
	}

	public static Plateau chargerFichier(String path) throws ParsingException {

		GestionFichier gestionFichier = new GestionFichier(path);
		String[] lignes = gestionFichier.readFile(path);
		LOGGER.info("lecture du fichier");
		Plateau plateau = null;
		if (lignes.length == 0) {
			throw new ParsingException("fichier vide");
		}
		// recuperation du coin superieur du plateau
		try {
			Position coinSuperieur = LoadElements.loadCoordonnees(lignes[0].split(" "));
			plateau = new Plateau(coinSuperieur);

			plateau = new Plateau(LoadElements.loadCoordonnees(lignes[0].split(" ")));
			//recuperation des tondeuses
			for (int i = 1; i < lignes.length; i++) {
				Tondeuse tondeuse = LoadElements.loadTondeuseCoordonneesEtOrientation(lignes[i]);
				i++;
				tondeuse.addActions(LoadElements.loadActions(lignes[i], coinSuperieur));
				plateau.addTondeuse(tondeuse);
			}
		} catch (IllegalPositionException e) {

			throw new ParsingException("Fichier formatee de facon incorrecte");
		}
		return plateau;
	}

	/**
	 * Lit le fichier en entree et retour un tableau de String, un élément pour
	 * chaque ligne
	 * 
	 * @param path
	 *            le chemin vers le fichier
	 * @return le tableau de String
	 * @throws ParsingException
	 *             Si un probleme est rencontre
	 */
	private String[] readFile(String path) throws ParsingException {
		LOGGER.info("chargement du fichier");
		FileReader fileReader = null;
		List<String> lignes = new ArrayList<String>();
		try {
			fileReader = new FileReader(path);
		} catch (FileNotFoundException e) {
			throw new ParsingException("Fichier non present");
		}
		// initialisation du bufffer
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(fileReader);
			// parcours des lignes
			String ligne = null;
			while ((ligne = bufferedReader.readLine()) != null) {
				lignes.add(ligne);
			}
		} catch (IOException e) {
			throw new ParsingException("Erreur en parsant le fichier");
		} finally {
			// fermeture du buffer
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				throw new ParsingException("Impossible de fermer le buffer");
			}
		}
		// conertit la liste en tableau
		return lignes.toArray(new String[lignes.size()]);
	}

}
