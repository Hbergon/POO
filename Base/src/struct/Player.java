package struct;

import java.util.ArrayList;


/**Classe représentant un joueur humain ou artificielle (dans le cas de la version de base seulement humain).<br/>
 * Les chateaux neutres sont considérés comme faisant parti du joueur vert.<br/>
 * il possède une couleur représenté par un int et un String pour son nom. Ces deux caractéristiques sont uniquement pour la lisibilité de l'utilisateur
 * @see Troupes#seigneur
 * @see Chateau#propio
 * @see Player#name
 * @see Player#color*/

public class Player {
	/**Nom permettant de différencier les joueurs autrement que par couleur*/
	private String name;
	/**Couleur permettant de différenciers les chateaux et troupes de différents joueurs.<br/>
	 * 0 pour le bleu, 1 pour le rouge, et 2 pour le vert (couleur réservé pour les chateau neutres).
	 * */
	private int color;
	
	/**Constructeur de player
	 * @param name : nom du joueur
	 * @param color : couleur du joueur
	 * @see color*/
	public Player(String name, int color){
		this.name=name;
		this.color = color;
	}

	/**Permet de récupérer le nom du joueur
	 * @return nom du joueur
	 * @see name*/
	public String getName() {
		return name;
	}

	/**Pemet de récupérer la couleur du joueur
	 * @return la couleur du joueur
	 * @see color*/
	public int getColor() {
		return color;
	}

	
}
