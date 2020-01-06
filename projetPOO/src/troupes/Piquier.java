package troupes;

public class Piquier extends Troupes {
	int cout = 100;
	int tmpProd =5;
	int speed =2;
	int pdv =1;
	int deg =1;
	
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
		return new Piquier();
	}
}
