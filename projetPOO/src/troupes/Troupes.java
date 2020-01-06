package troupes;
import struct.*;



/** Classe abstraite repr�sentant une troupe quelconque (dans la version basique uniquement Piquier).<br/>
 * Elle est carac�ris�e par un co�t, un temps de priduction, une vitesse de d�placement, des points de vie,
 *  des d�gats et son propri�taire.<br/> Elles comportent aussi les informations suivantes : sa position actuelle pour les deux
 *   coordonn�es, le chateau de destination ainsi que la position de ce dernier. <br/> Le champ lastX indique si le dernier mouvement
 *   �t� suivant l'axe des abscisses.
 *   @see Piquier
 * @see Troupes#cout
 * @see Troupes#tmpProd
 * @see Troupes#speed
 * @see Troupes#pdv
 * @see Troupes#deg
 *
 *
 
 * 
 * */
 
 
public abstract class Troupes {
	/** Co�t en tr�sor de l'unit� 
	 * @see Chateau#tresor*/
	private int cout; 
	/** Temps de producttion n�cessaire � la cr�ation de la troupe 
	 * @see Chateau#prod
	 * */
	private int tmpProd;
	/**Vitesse de D�placement de l'unit� hors d'un chateau
	 * @see Main#newPs(Troupes, int)*/
	private int speed;
	/**Point de vie restant de l'unit�
	 * @see Chateau#attaque(troupes.Troupes)*/
	private int pdv;
	/**D�gats que l'unit" est capable d'infliger
	 * @see Chateau#attaque(troupes.Troupes)*/
	private int deg;
	/**Position actuelle sur l'axe des abscisse de l'unit� 
	 * @see Main#newPos(Troupes, int)*/
	private int position_x;
	/**Position actuelle sur l'axe des ordonn�es de l'unit� 
	 * @see Main#newPos(Troupes, int)*/
	private int position_y;
	/**Position du chateau cible sur l'axe des abcisses
	 * @see Troupes#cible*/
	private int aimX;
	/**Position du chateau cible sur l'axe des ordonn�es
	 * @see Troupes#cible*/
	private int aimY;
	/** Chateau qui est la cible de cette unit�
	 * @see Troupes#cible
	 * @see Main#orderAux(Chateau, Chateau, Troupes, int)*/
	private Chateau cible;
	/**Joueur qui poss�de cette Troupe
	 * @see Player*/
	private Player seigneur;
	/**Bool�en qui est vrai lorsque le dernier mouvement effectu� a �t� fait le long de l'axe des abscisses*/
	private Boolean lastX = false;
	
	
	/**Permet de connaitre le cout de l'unit�
	 * @return un Co�t
	 * @see Troupes#cout*/
	public int getCout() {
		return cout;
	}
	
	/**Permet de connaitre le temps de production de la Troupe
	 * @return le temps de production de l'unit�
	 * @see Troupes#tmpProd
	 * */
	
	public int getTmpProd() {
		return tmpProd;
	}

	/**permet de connaitre les points de vie restants
	 * @return les points de vie restants
	 * @see Troupe#pdv*/
	public int getPdv() {
		return pdv;
	}
	
	/**Permet de connaitre la vitesse de cette unit�
	 * @return la vitesse de l'unit�
	 * @see Troupes#speed*/
	public int getSpeed() {
		return speed;
	}
	
	/**Permet de connaitre les d�gats que l'unit� peut infliger
	 * @return les d�gats de l'unit�
	 * @see Troupes#deg*/
	public int getDeg() {
		return deg;
	}
	
	/**Permet de modifier les points de vie de l'unit�
	 * @param vie : la nouvelle quantiti� de pdv
	 * @see Troupes#pdv*/
	public void setPdv(int vie) {
		pdv=vie;
		return;
	}

	/**Permet de connaitre la position sur l'axe des abscisses de cette unit�
	 * @return la position de l'unit�
	 * @see Troupes#position_x*/
	public int getPosition_x() {
		return position_x;
	}

	/**permet de changer la position sur l'axe des abscisses de la troupe
	 * @param position_x : nouvelle position
	 * @see Troupes#position_x*/
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	/**Permet de connaitre la position sur l'axe des ordonn�es de cette unit�
	 * @return la position de l'unit�
	 * @see Troupes#position_y*/
	public int getPosition_y() {
		return position_y;
	}

	/**permet de changer la position sur l'axe des ordonn�es de la troupe
	 * @param position_x : nouvelle position
	 * @see Troupes#position_y*/
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	
	/**permet de connaitre le joueur propi�taire de la troupe
	 * @return le joueur propi�taire
	 * @see Troupes#seigneur*/
	public Player getPlayer() {
		return seigneur;
	}
	
	/**permet de modifier le joueur propri�taire de la troupe
	 * @param saigneur : nouveau propri�tairede la troupe
	 * @see Troupes#seigneur*/
	public void setPlayer(Player seigneur) {
		this.seigneur = seigneur;
	}

	/**permet de connaitre la position sur l'axe des abscisses de la troupe
	 * @return la position de la cible
	 * @see Troupes#aimX*/
	public int getAimX() {
		return aimX;
	}
	
	
	/**permet de connaitre la position sur l'axe des ordonn�es de la troupe
	 * @return la position de la cible
	 * @see Troupes#aimY*/
	public int getAimY() {
		return aimY;
	}

	/**Permet de modifier la position qui sera cibl� par l'unit�
	 * @param h : hauteur du chateau
	 * @param w : largeur du chateau
	 * @see Troupes#aimY
	 * @see Troupes#aimX*/
	public void setAim(int h, int w) {
		this.aimX = cible.getPosition_x() + h/2;
		this.aimY = cible.getPosition_y() + w/2;
	}
	
	/**Permet de savoir si le dernier mouvement suivait l'axe des abscisses
	 * @see Troupes#lastX*/
	public Boolean getLastX() {
		return lastX;
	}

	/**Permet d�finir le dernier mouvment comme ayant mouvement suivit l'axe des abscisses
	 * @param lastX
	 * @see Troupes#lastX*/
	public void setLastX(Boolean lastX) {
		this.lastX = lastX;
	}
	
	/**Permet de faire une copie de l'unit�, cette m�thode est red�finie dans chaque sous-classe de Troupes
	 */
	public Troupes copy() {
		return this;
	}

	/**Permet de connaitre la cible de cette unit�
	 * @return le chateau cible
	 * @see Troupes#cible*/
	public Chateau getCible() {
		return cible;
	}

	/**permet de choisir une cible poour cette unit�
	 * @param cible : chateau cibl�
	 * @param h : hauteur du chateau
	 * @param w : largeur du chateau
	 * @see Troupes#cibles
	 * @see Main#castleWidth
	 * @see Main#castleHeight*/
	public void setCible(Chateau cible, int h, int w) {
		this.cible = cible;
		this.setAim(h, w);
	}
}