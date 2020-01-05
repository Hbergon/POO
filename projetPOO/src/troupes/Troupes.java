package troupes;
import struct.*;
import struct.Player;



public abstract class Troupes {
	private int cout;
	private int tmpProd;
	private int speed;
	private int pdv;
	private int deg;
	private String name;
	private int position_x, position_y;
	private int aimX, aimY;
	private Chateau cible;
	private Player seigneur;
	private Boolean lastX = false;
	
	
	
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
	
	public String getName() {
		return name;
	}

	public void setPdv(int vie) {
		pdv=vie;
		return;
	}

	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public int getPosition_y() {
		return position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	
	public Player getPlayer() {
		return seigneur;
	}

	public void setPlayer(Player seigneur) {
		this.seigneur = seigneur;
	}

	public int getAimX() {
		return aimX;
	}
	
	public int getAimY() {
		return aimY;
	}

	public void setAim() {
		this.aimX = cible.getPosition_x();
		this.aimY = cible.getPosition_y();
	}
	
	public Boolean getLastX() {
		return lastX;
	}

	public void setLastX(Boolean lastX) {
		this.lastX = lastX;
	}
	
	public Troupes copy() {
		return this;
	}

	public Chateau getCible() {
		return cible;
	}

	public void setCible(Chateau cible) {
		this.cible = cible;
		this.setAim();
	}
	
}