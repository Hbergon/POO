package struct;

import java.util.ArrayList;

import troupes.*;

/**Classe fille de Structure, poss�de une position suivant l'axe des abscisses et des ordonn�es
 * @see Struture*/
public class Chateau extends Structure{
	/**@see Struture#proprio*/
	private Player proprio;
	/**@see Struture#troupe*/
	public ArrayList<Troupes> troupe;
	/**@see Structure#prod*/
	private int prod;
	/**@see Struture#file*/
	private ArrayList<Troupes> file;
	/**Argent contenu dans ce chateau, sert � lancer des production de troupe
	 * @see Troupes#cout*/
	private int tresor;
	/**Position du chateau suivant l'axe des abscisses*/
	private int position_x;
	/**Position du chateau suivant l'axe des ordonn�es*/
	private int position_y;
	/**Niveau du chateau*/
	private int lvl=1;
	/**Permet de sauver la progression d'une prod avant le lancement d'une am�lioration
	 * @see Chateau#upCastle()*/
	private int prodTmp;
	/**Vrai si le chateau est en am�lioration*/
	private boolean upgrade;
	/**orientaion du chateau : 0 pour Nord, 1 pour Est, 2 pour Sud, 3 pour Ouest*/
	private int orientation;
	
	
	/**Constructeur de chateau
	 * @param proprio : permet de d�finir le propri�taire
	 * @param x : permet de d�finir la position du chateau suivant l'axe des abscisses
	 * @param y : permet de d�finir la position du chateau suivant l'axe des ordonn�es
	 * @see setTresor
	 * @see setProprio*/
	public Chateau(Player proprio, int x, int y){
		lvl = 1;
		orientation = 2;
		this.setProprio(proprio);
		troupe = new ArrayList<Troupes>();
		prod = 0;
		file = new ArrayList<Troupes>();
		setTresor(0);
		this.position_x = x;
		this.position_y = y;
	}
	
	/**permet de r�cup�rer le niveau du chateau
	 * @return : valeur du niveau
	 * @see Chateau#lvl*/
	public int getLvl() {
		return lvl;
	}
	
	/**Permet de r�cup�rer une Troupes de troupe
	 * @param indexe o� se trouve la Troupes voulue
	 * @return la Troupes qui se trouve � la ind-1 �me position dans troupe
	 * @see Troupes
	 * @see troupe
	 * @see ArrayList*/
	public Troupes getSomeTroupe(int ind) {
		return troupe.get(ind);
	}
	
	/**Permet d'ajouter une Toupes � troupe
	 * @param t : Troupes � a jouter
	 * @see Troupes
	 * @see Chateau#troupe
	 * @see ArrayList*/
	public void addSomeTroupe(Troupes t) {
		troupe.add(t);
		return;
	}
	
	/**Permet de r�cup�rer troupe
	 * return troupe
	 * @see Troupes
	 * @see Chateau#troupe
	 * @see ArrayList*/
	public ArrayList<Troupes> getTroupe() {
		return troupe;
	}
	
	/**Permet de supprim� le premier �l�ment de troupe
	 * @see Troupes
	 * @see Chateau#troupe
	 * @see ArrayList*/
	public void removeTroupeFirst() {
		troupe.remove(0);
		return;
	}
	
	/**Permet de supprim� un �l�ment pr�cis de troupe
	 * @param ind : indice de la position � se trouve l'�l�ment
	 * @see Chateau#troupe
	 * @see ArrayList*/
	public void removeTroupe(int ind) {
		troupe.remove(ind);
		return;
	}
	
	/**Permet de r�cup�rer file
	 * return file
	 * @see Chateau#file
	 * @see ArrayList*/
	public ArrayList<Troupes> getList() {
		return file;
	}
	
	/**Permet de r�cup�rer un �l�ment en t�te de file
	 * @see Chateau#file
	 * @see ArrayList*/
	public Troupes getFirstList() {
		 return file.get(0);
	}
	
	/**permet de r�cup�rer le temps restant de production
	 * @return temps de production restante en tour
	 * @see Chateau#prod*/
	public int getProd() {
		return prod;
	}

	/**Affecte un niveau au chateau
	 * @param lvl : nouveau niveau
	 * @see Chateau#lvl*/
	public void setLvl(int lvl) {
		this.lvl=lvl;
		return;
	}
	
	/**Permet de modifier le temps de production restant
	 *@param nouveau coup
	 *@see Chateau#prod*/
	public void setProd(int cout) {
		prod=cout;
		return;
	}

	/**R�cup�re l'orientation du chateau
	 * @return : la valeur de l'orientation
	 * @see Chateau#orientation*/
	public int getOrientation() {
		return orientation;
	}

	/**Affecte une orientation
	 * @param orientation : orientation souhait�e
	 * @see Chateau#orientation*/
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	/**Permet de r�cuperer la valeur du tr�sor du chateau
	 * @return la valeur de tresor
	 * @see Chateau#tresor*/
	public int getTresor() {
		return tresor;
	}

	/**permet d'affecter une valeur au tr�sor du chateau
	 * @param tresor : valeur � affecter
	 * @see Chateau#tresor*/
	public void setTresor(int tresor) {
		this.tresor = tresor;
	}

	/**Permet de r�cup�rer la position suivant l'axe des abscisses du chateau
	 * @return la position du chateau
	 * @see Chateau#position_x*/
	public int getPosition_x() {
		return position_x;
	}

	/**Permet de modifer la position suivant l'axe des abscisses du chateau
	 * @param position_x : la nouvelle position
	 * @see Chateau#position_x*/
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	/**Permet de r�cup�rer la position suivant l'axe des ordonn�es du chateau
	 * @return la position du chateau
	 * @see Chateau#position_y*/
	public int getPosition_y() {
		return position_y;
	}

	/**Permet de modifer la position suivant l'axe des ordonn�es du chateau
	 * @param position_y : la nouvelle position
	 * @see Chateau#position_y*/
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}

	/**Permet de r�cup�rer le propri�taire du chateau
	 * @return le propri�taire du chateau
	 * @see Chateau#proprio
	 * @see Player*/
	public Player getProprio() {
		return proprio;
	}

	/**Permet de modifer le propri�taire du chateau
	 * @param proprio : nouveau propri�taire
	 * @see Chateau#proprio
	 * @see Player*/
	public void setProprio(Player proprio) {
		this.proprio = proprio;
	}
	
	/**Augmente la valeur du tr�sor correspondant � l'augmentation du tr�sor au cours du temps et en fonction du niveau
	 * @see Chateau#tresor*/
	public void increaseTresor() {
		this.tresor = this.tresor + this.lvl * 10;
	}
	
	/**Ajoute une production en payant son co�t
	 * @param tr : Troupes demand�e
	 * @see Chateau#file
	 * @see Chateau#tresor
	 * @see Troupes*/
	public void addProd(Troupes tr) {
		if(this.tresor >= tr.getCout()) {
			this.tresor = this.tresor - tr.getCout();
			this.file.add(tr);
		}
	}
	
	/**Permet l'am�lioration du chateau et de garder la proggression de la production en cours
	 * @see Chateau#tmpProd
	 * @see Chateau#lvl*/
	public void upCastle() {
		if(!this.upgrade && this.tresor >= 1000*this.getLvl()) {
			this.tresor = this.tresor - 1000*this.getLvl();
			this.upgrade = true;
			this.prodTmp = this.prod;
			this.prod = 100 + 50*this.lvl;
		}
	}
	
	/**Consid�re la production pr�c�dante termin�e et lance la nouvelle production
	 * @see Chateau#file
	 * @see Chateau#troupe
	 * @see Troupes*/
	public void endProd() {
		if(this.upgrade) {
			this.setLvl(this.lvl +1);
			this.upgrade = false;
			if((this.file.size())>0) {
				this.prod = this.prodTmp;
			}
		}else {
			if((this.file.size())>0) {
				Troupes tmp = this.getFirstList();
				tmp.setPlayer(this.proprio);
				this.troupe.add(tmp);
				this.file.remove(0);
				this.prod = tmp.getTmpProd();
			}
		}
	}
	
	/**Annule un eproduction donn�e et rembourse son propri�taire
	 * @param ind : indexe o� se trouve la production dans file
	 * @see Chateau#tresor
	 * @see Chateau#file
	 * @see Troupes*/
	public void cancelProd(int ind) {
		if((this.file.size())>=(ind+1)) {
			Troupes tmp = this.file.get(ind);
			if(ind !=0) {
				this.tresor = this.tresor + tmp.getCout();
			}else {
				this.prod = 0;
			}
			this.file.remove(ind);
		}
	}
	
	/**Met � jour la production du chateau et son or
	 * @see Chateau#file
	 * @see Chateau#prod
	 * @see Chateau#tr�sor
	 * @see Chateau#increaseTresor()
	 * @see Chateau#endprod()*/
	public void updateProd() {
		this.increaseTresor();
		if(this.prod <= 0) {
			this.endProd();
		}else {
			this.prod = this.prod -1;
		}
	}
	
	/**G�re tout interraction de troupes ext�rieurs sur ce chateau
	 * @param tr : Troupes interragissante
	 * @see Chateau#troupe
	 * @see Chateau#attaque(Troupes)
	 * @see Troupes
	 * @see Troupes#copy()*/
	public void TroupeInteraction(Troupes tr) {
		if(tr.getPlayer() != this.proprio) {
			this.attaque(tr);
		}else{
			if(tr.getClass() == Convoyeur.class) {
				convoyeurInteraction((Convoyeur) tr);
			}else {
				this.troupe.add(tr.copy());
			}
		}
	}

	/**G�re les attaques sur ce chateau ainsi que leur prise
	 * @param tr : Troupes attaquante
	 * @see @chateau#troupe
	 * @see Troupes
	 * @see Troupes#pdv
	 * @see Troupes#deg*/
	public void attaque(Troupes tr) {
		if(this.troupe.size()==0) {
			this.proprio = tr.getPlayer();
			while(this.file.size() != 0) {
				this.file.remove(0);
			}
			this.troupe.add(tr);
		}else {
			int tmp = this.getSomeTroupe(0).getPdv();
			this.troupe.get(0).setPdv(tmp - tr.getDeg());
			if(tmp <= tr.getDeg()) {
				this.troupe.remove(0);
			}
		}
	}
	
	/**G�re l'apport d'argent via convoyeur
	 * @param c : convoyeur re�us
	 * @see Troupes#convoyeur*/
	public void convoyeurInteraction(Convoyeur c) {
		this.setTresor(getTresor() + c.getTresor());
	}
	

}
