package Struct;

import java.util.ArrayList;

import Troupes.Troupes;

public class Chateau {
	private int lvl=1;
	//private Player proprio;
	private ArrayList<Troupes> troupe;
	private int prod;
	private ArrayList<Troupes> file;
	private int orientation;
	private int tresor;
	
	
	public Chateau(/*player*/){
		lvl=1;
		//proprio = player;
		troupe = new ArrayList<Troupes>();
		prod = 0;
		file = new ArrayList<Troupes>();
		setTresor(0);
	}
	
	public int getLvl() {
		return lvl;
	}
	
	/*public Player getPlayer() {
		return proprio;
	}*/

	public Troupes getSomeTroupe(int ind) {
		return troupe.get(ind);
	}
	
	public ArrayList<Troupes> getTroupe() {
		return troupe;
	}
	
	public void removeFirstTroupe() {
		troupe.remove(0);
		return ;
	}
	
	public void addToTroupe(Troupes tr) {
		troupe.add(tr);
		return;
	}
	
	public ArrayList<Troupes> getList() {
		return file;
	}
	
	public Troupes getFirstList() {
		 return file.get(0);
	}
	
	public void removeFirstList() {
		file.remove(0);
		return ;
	}
	
	
	public int getProd() {
		return prod;
	}

	public void setLvl(int lvl) {
		this.lvl=lvl;
		return;
	}
	
	public void setProd(int cout) {
		prod=cout;
		return;
	}
	
	public void addToFile(Troupes tr) {
		file.add(tr);
		return;
	}

	public int getOrientation() {
		return orientation;
	}

	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}

	public int getTresor() {
		return tresor;
	}

	public void setTresor(int tresor) {
		this.tresor = tresor;
	}
	
	/*public void increaseTresor() {
		
	}*/
}
