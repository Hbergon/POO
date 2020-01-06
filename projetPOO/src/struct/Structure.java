package struct;
import java.util.ArrayList;

import troupes.*;

/**Classe abstraite repr�sentant les chateaux (dans les deux versions cela repr�sente seulement le chateau<br/>
 * Elle est caract�ris� par son propri�taire, les troupes en garnison, l'avancement de production et la liste des unit� en productions
 * @see Chateau
 * @see Troupes
 * @see proprio
 * @see troupe
 * @see file
 * @see prod */
public abstract class Structure {
	/**Joueur propri�taire de la struture
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
	/**File d'attente de production, le premier �l�ment est en cours de production
	 * @see Chateau#file
	 * @see ArrayList*/
	private ArrayList<Troupes> file;

	
	/**Permet de r�cup�rer le propri�taire de la structure
	 * @return le joueur propri�taire
	 * @see PLayer*/
	public Player getPlayer() {
		return proprio;
	}
	
}
