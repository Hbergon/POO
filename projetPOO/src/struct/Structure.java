package struct;
import java.util.ArrayList;

import troupes.*;

/**Classe abstraite représentant les chateaux (dans les deux versions cela représente seulement le chateau<br/>
 * Elle est caractérisé par son propriétaire, les troupes en garnison, l'avancement de production et la liste des unité en productions
 * @see Chateau
 * @see Troupes
 * @see proprio
 * @see troupe
 * @see file
 * @see prod */
public abstract class Structure {
	/**Joueur propriétaire de la struture
	 * @see Player
	 * @see Chateau#proprio
	 * */
	private Player proprio;
	
	/**Garnison de la structure
	 * @see Chateau#troupe
	 * @see ArrayList*/
	private ArrayList<Troupes> troupe;
	/**Temps restant avant la fin d'une production
	 * @see Chateau#prod*/
	private int prod;
	/**File d'attente de production, le premier élément est en cours de production
	 * @see Chateau#file
	 * @see ArrayList*/
	private ArrayList<Troupes> file;

	
	/**Permet de récupérer le propriétaire de la structure
	 * @return le joueur propriétaire
	 * @see PLayer*/
	public Player getPlayer() {
		return proprio;
	}
	
}
