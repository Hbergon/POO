package Troupes;

public class Piquier extends Troupes {
	int cout;
	int tmpProd;
	int speed;
	int pdv;
	int deg;
	String name;
	
	
	public Piquier() {
		System.out.println("test");
		cout= 100;
		tmpProd= 5;
		speed=2;
		pdv=1;
		deg=1;
		name="Piquier";
	}
	
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
