package troupes;

public class Onagre extends Troupes {
	int cout= 1000;
	int tmpProd= 50;
	int speed=1;
	int pdv=5;
	int deg=10;
	
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
	
	public Troupes copy() {
		return new Onagre();
	}
}
