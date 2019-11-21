package Troupes;

public abstract class Troupes {
	private int cout;
	private int tmpProd;
	private int speed;
	private int pdv;
	private int deg;
	private String name;

	
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
