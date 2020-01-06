package troupes;
import struct.*;



/** Classe abstraite représentant une troupe quelconque (dans la version basique uniquement Piquier).<br/>
 * Elle est caracérisée par un coût, un temps de priduction, une vitesse de déplacement, des points de vie,
 *  des dégats et son propriétaire.<br/> Elles comportent aussi les informations suivantes : sa position actuelle pour les deux
 *   coordonnées, le chateau de destination ainsi que la position de ce dernier. <br/> Le champ lastX indique si le dernier mouvement
 *   été suivant l'axe des abscisses.
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
	/** Coût en trésor de l'unité 
	 * @see Chateau#tresor*/
	private int cout; 
	/** Temps de producttion nécessaire à la création de la troupe 
	 * @see Chateau#prod
	 * */
	private int tmpProd;
	/**Vitesse de Déplacement de l'unité hors d'un chateau
	 * @see Main#newPs(Troupes, int)*/
	private int speed;
	/**Point de vie restant de l'unité
	 * @see Chateau#attaque(troupes.Troupes)*/
	private int pdv;
	/**Dégats que l'unit" est capable d'infliger
	 * @see Chateau#attaque(troupes.Troupes)*/
	private int deg;
	/**Position actuelle sur l'axe des abscisse de l'unité 
	 * @see Main#newPos(Troupes, int)*/
	private int position_x;
	/**Position actuelle sur l'axe des ordonnées de l'unité 
	 * @see Main#newPos(Troupes, int)*/
	private int position_y;
	/**Position du chateau cible sur l'axe des abcisses
	 * @see Troupes#cible*/
	private int aimX;
	/**Position du chateau cible sur l'axe des ordonnées
	 * @see Troupes#cible*/
	private int aimY;
	/** Chateau qui est la cible de cette unité
	 * @see Troupes#cible
	 * @see Main#orderAux(Chateau, Chateau, Troupes, int)*/
	private Chateau cible;
	/**Joueur qui possède cette Troupe
	 * @see Player*/
	private Player seigneur;
	/**Booléen qui est vrai lorsque le dernier mouvement effectué a été fait le long de l'axe des abscisses*/
	private Boolean lastX = false;
	
	
	/**Permet de connaitre le cout de l'unité
	 * @return un Coût
	 * @see Troupes#cout*/
	public int getCout() {
		return cout;
	}
	
	/**Permet de connaitre le temps de production de la Troupe
	 * @return le temps de production de l'unité
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
	
	/**Permet de connaitre la vitesse de cette unité
	 * @return la vitesse de l'unité
	 * @see Troupes#speed*/
	public int getSpeed() {
		return speed;
	}
	
	/**Permet de connaitre les dégats que l'unité peut infliger
	 * @return les dégats de l'unité
	 * @see Troupes#deg*/
	public int getDeg() {
		return deg;
	}
	
	/**Permet de modifier les points de vie de l'unité
	 * @param vie : la nouvelle quantitié de pdv
	 * @see Troupes#pdv*/
	public void setPdv(int vie) {
		pdv=vie;
		return;
	}

	/**Permet de connaitre la position sur l'axe des abscisses de cette unité
	 * @return la position de l'unité
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

	/**Permet de connaitre la position sur l'axe des ordonnées de cette unité
	 * @return la position de l'unité
	 * @see Troupes#position_y*/
	public int getPosition_y() {
		return position_y;
	}

	/**permet de changer la position sur l'axe des ordonnées de la troupe
	 * @param position_x : nouvelle position
	 * @see Troupes#position_y*/
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	
	/**permet de connaitre le joueur propiétaire de la troupe
	 * @return le joueur propiétaire
	 * @see Troupes#seigneur*/
	public Player getPlayer() {
		return seigneur;
	}
	
	/**permet de modifier le joueur propriétaire de la troupe
	 * @param saigneur : nouveau propriétairede la troupe
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
	
	
	/**permet de connaitre la position sur l'axe des ordonnées de la troupe
	 * @return la position de la cible
	 * @see Troupes#aimY*/
	public int getAimY() {
		return aimY;
	}

	/**Permet de modifier la position qui sera ciblé par l'unité
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

	/**Permet définir le dernier mouvment comme ayant mouvement suivit l'axe des abscisses
	 * @param lastX
	 * @see Troupes#lastX*/
	public void setLastX(Boolean lastX) {
		this.lastX = lastX;
	}
	
	/**Permet de faire une copie de l'unité, cette méthode est redéfinie dans chaque sous-classe de Troupes
	 */
	public Troupes copy() {
		return this;
	}

	/**Permet de connaitre la cible de cette unité
	 * @return le chateau cible
	 * @see Troupes#cible*/
	public Chateau getCible() {
		return cible;
	}

	/**permet de choisir une cible poour cette unité
	 * @param cible : chateau ciblé
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