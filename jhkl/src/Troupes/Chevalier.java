package Troupes;

public class Chevalier extends Troupes {
	int cout= 500;
	int tmpProd= 20;
	int speed=6;
	int pdv=3;
	int deg=5;
	String name="Chevalier";
	
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
}
