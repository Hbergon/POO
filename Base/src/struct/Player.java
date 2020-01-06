package struct;

import java.util.ArrayList;


/**Classe repr�sentant un joueur humain ou artificielle (dans le cas de la version de base seulement humain).<br/>
 * Les chateaux neutres sont consid�r�s comme faisant parti du joueur vert.<br/>
 * il poss�de une couleur repr�sent� par un int et un String pour son nom. Ces deux caract�ristiques sont uniquement pour la lisibilit� de l'utilisateur
 * @see Troupes#seigneur
 * @see Chateau#propio
 * @see Player#name
 * @see Player#color*/

public class Player {
	/**Nom permettant de diff�rencier les joueurs autrement que par couleur*/
	private String name;
	/**Couleur permettant de diff�renciers les chateaux et troupes de diff�rents joueurs.<br/>
	 * 0 pour le bleu, 1 pour le rouge, et 2 pour le vert (couleur r�serv� pour les chateau neutres).
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

	/**Permet de r�cup�rer le nom du joueur
	 * @return nom du joueur
	 * @see name*/
	public String getName() {
		return name;
	}

	/**Pemet de r�cup�rer la couleur du joueur
	 * @return la couleur du joueur
	 * @see color*/
	public int getColor() {
		return color;
	}

	
}
