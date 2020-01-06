package troupes;

import struct.Chateau;
import struct.Player;

/**Classe fille de Troupes
 * @see Troupes*/
public class Convoyeur extends Troupes{
	int cout = 1000;
	int tmpProd = 50;
	int speed = 1;
	int deg = 0;
	int pdv = 1;
	int position_x, position_y;
	int aimX, aimY;
	Chateau cible;
	Player seigneur;
	Boolean lastX = false;
	/**valeur du trésor transporté*/
	int tresor;
	
	public int getCout() {
		return cout;
	}
	
	public int getTmpProd() {
		return tmpProd;
	}

	public int getPdv() {
		return pdv;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getDeg() {
		return deg;
	}

	public void setPdv(int vie) {
		pdv=vie;
		return;
	}
	
	/**Constructeur du convoyeur
	 * @param tresor : trésor à transporter*/
	public Convoyeur(int tresor) {
		this.tresor = tresor;
	}
	
	public Troupes copy() {
		return new Convoyeur(this.tresor);
	}
	
	/**permet de récupérer la valeur du trésor tansporté
	 * @return : valeur du trésor*/
	public int getTresor() {
		return tresor;
	}
}
